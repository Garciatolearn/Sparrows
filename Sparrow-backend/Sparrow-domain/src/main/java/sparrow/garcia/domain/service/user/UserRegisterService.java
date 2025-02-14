package sparrow.garcia.domain.service.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import sparrow.garcia.domain.model.entity.user.UserDTO;
import sparrow.garcia.domain.repository.user.IUserAccountRepository;

@Service
public class UserRegisterService {

    @Resource
    IUserAccountRepository userAccountRepository;

    @Resource
    UserCommonService userCommonService;

    //先不考虑高并发情况下 用户名称的重复(处理方案,上redis 锁)
    public Boolean createAccount(String email,String username,String password){
        UserDTO userDTO = userAccountRepository.selectUserByEmailOrUsername(email, username);
        if (userDTO != null) return Boolean.FALSE;
        String salt = userCommonService.createSalt();
        String passwdEncode = userCommonService.passwdEncode(password,salt);
        userDTO = new UserDTO().setSalt(salt).setEmail(email).setUsername(username).setPassword(passwdEncode);
        if(userAccountRepository.insertUserAccount(userDTO) != 1) return Boolean.FALSE;
        return Boolean.TRUE;
    }


}
