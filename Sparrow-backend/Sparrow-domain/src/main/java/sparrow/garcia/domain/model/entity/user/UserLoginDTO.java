package sparrow.garcia.domain.model.entity.user;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLoginDTO {

    /**
     * 默认值为@null 索引
     * */
    private String email;

    /**
     * default"小炫雀"
     * */
    private String username;

    /**
     * 加密前的密码
     * */
    private String password;


}
