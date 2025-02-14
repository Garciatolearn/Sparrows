package sparrow.garcia.domain.model.entity.user;

import lombok.Data;
import lombok.experimental.Accessors;
import sparrow.garcia.domain.model.valueobj.user.UserStatusVO;

@Data
@Accessors(chain = true)
public class UserDTO {

    /**
     * 默认值为'0' 索引，唯一索引
     * */
    private String phone;

    /**
     * 默认值为@null 索引
     * */
    private String email;

    /**
     * default"小炫雀"
     * */
    private String username;

    /**
     * 加密的盐
     * */
    private String salt;

    /**
     * "default image" 头像
     * */
    private String image;

    /**
     * "欧耶,逆逆的转" 用户签名
     * */
    private String signature;

    /**
     * 0 为正常,1为封禁
     * */
    private UserStatusVO userStatus;

    /**
     * 加密后的密码
     * */
    private String password;
}
