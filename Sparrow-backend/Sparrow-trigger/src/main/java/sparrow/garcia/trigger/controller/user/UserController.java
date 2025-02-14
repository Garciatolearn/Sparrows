package sparrow.garcia.trigger.controller.user;

import jakarta.annotation.Resource;
import org.sparrow.common.http.ErrorCode;
import org.sparrow.common.http.Result;
import org.sparrow.common.http.Results;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sparrow.garcia.domain.model.entity.user.UserLoginDTO;
import sparrow.garcia.domain.model.entity.user.UserRegisterDTO;
import sparrow.garcia.domain.service.user.UserLoginService;
import sparrow.garcia.domain.service.user.UserRegisterService;

@RestController
public class UserController {

    @Resource
    UserLoginService userLoginService;

    @Resource
    UserRegisterService userRegisterService;

    @PostMapping("/api/user/login")
    public Result userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        return userLoginService.userLogin(userLoginDTO);
    }

    @PostMapping("api/user/register")
    public Result userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterService.createAccount(userRegisterDTO.getEmail()
                , userRegisterDTO.getUsername()
                , userRegisterDTO.getPassword())) return Results.success();
        return Results.failure(ErrorCode.USER_REGISTER_ERROR);
    }

}
