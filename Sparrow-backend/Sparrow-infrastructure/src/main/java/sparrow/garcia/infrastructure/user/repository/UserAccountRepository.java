package sparrow.garcia.infrastructure.user.repository;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import sparrow.garcia.domain.model.entity.user.UserDTO;
import sparrow.garcia.domain.model.valueobj.user.UserStatusVO;
import sparrow.garcia.domain.repository.user.IUserAccountRepository;
import sparrow.garcia.infrastructure.user.dao.IUserAccountDao;
import sparrow.garcia.infrastructure.user.po.UserPO;

@Repository
public class UserAccountRepository implements IUserAccountRepository {

    @Resource
    IUserAccountDao userAccountDao;
    @Override
    public UserDTO selectUserByEmailOrUsername(String email, String username) {
        LambdaQueryWrapper<UserPO> userPOLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userPOLambdaQueryWrapper.eq(UserPO::getEmail,email).or().eq(UserPO::getUsername,username);
        UserPO userPO = userAccountDao.selectOne(userPOLambdaQueryWrapper);
        if (userPO == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setPhone(userPO.getPhone());
        userDTO.setEmail(userPO.getEmail());
        userDTO.setUsername(userPO.getUsername());
        userDTO.setSalt(userPO.getSalt());
        userDTO.setImage(userPO.getImage());
        userDTO.setSignature(userPO.getSignature());
        userDTO.setUserStatus(UserStatusVO.getUserStatus(userPO.getUserStatus()));
        userDTO.setPassword(userPO.getPassword());
        return userDTO;
    }

    @Override
    public int insertUserAccount(UserDTO userDTO) {
        UserPO userPO = new UserPO();
        userPO.setEmail(userDTO.getEmail());
        userPO.setUsername(userDTO.getUsername());
        userPO.setPassword(userDTO.getPassword());
        userPO.setSalt(userDTO.getSalt());
        return userAccountDao.insert(userPO);
    }
}
