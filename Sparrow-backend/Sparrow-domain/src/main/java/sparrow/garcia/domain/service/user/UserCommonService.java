package sparrow.garcia.domain.service.user;

import cn.hutool.core.util.RandomUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import sparrow.garcia.domain.model.entity.user.UserDTO;

@Service
public class UserCommonService {

    public String passwdEncode(String passwd,String salt){
        String hashpw = BCrypt.hashpw(passwd, salt);
        return hashpw;
    }

    public String createSalt(){
        return RandomUtil.randomString(12);
    }

}
