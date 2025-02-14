package sparrow.garcia.domain.service.user;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import org.sparrow.common.http.ErrorCode;
import org.sparrow.common.http.Result;
import org.sparrow.common.http.Results;
import org.sparrow.common.tools.JwtUtil;
import org.sparrow.common.user.entity.UserInfDTO;
import org.springframework.stereotype.Service;
import sparrow.garcia.domain.model.entity.user.UserDTO;
import sparrow.garcia.domain.model.entity.user.UserLoginDTO;
import sparrow.garcia.domain.repository.user.IUserAccountRepository;

@Service
public class UserLoginService {

    @Resource
    IUserAccountRepository userAccountRepository;

    @Resource
    UserCommonService userCommonService;

    public Result userLogin(UserLoginDTO userLoginDTO){
        UserDTO userDTO = userAccountRepository.selectUserByEmailOrUsername(userLoginDTO.getEmail(),
                userLoginDTO.getUsername());
        if(userDTO == null) return Results.failure(ErrorCode.USER_DATA_EXCLUDE);
        //todo 责任链来处理参数校验问题
        String password = userDTO.getPassword();
        String salt = userDTO.getSalt();
        String loginDTOPassword = userLoginDTO.getPassword();
        String loginPasswdEncode = userCommonService.passwdEncode(loginDTOPassword, salt);
        if(StrUtil.equals(password,loginPasswdEncode)) {
            UserInfDTO userInfDTO = new UserInfDTO();
            userInfDTO.setUsername(userLoginDTO.getUsername());
            String userToken = JwtUtil.createUserToken(userInfDTO);
            return Results.success(userToken);
        }
        return Results.failure(ErrorCode.USER_PASSWD_VERIFY_ERROR);
    }

}
