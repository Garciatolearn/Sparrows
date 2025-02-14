package sparrow.garcia.trigger.controller.user;

import jakarta.annotation.Resource;
import org.sparrow.common.http.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sparrow.garcia.domain.model.entity.user.UserLoginDTO;
import sparrow.garcia.domain.service.user.UserLoginService;

@RestController
public class UserController {

    @Resource
    UserLoginService userLoginService;

    @PostMapping("user/login")
    public Result userLogin(@RequestBody UserLoginDTO userLoginDTO){
        return userLoginService.userLogin(userLoginDTO);
    }


}
