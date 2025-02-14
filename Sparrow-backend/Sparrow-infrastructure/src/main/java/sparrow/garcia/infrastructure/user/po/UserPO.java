package sparrow.garcia.infrastructure.user.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import sparrow.garcia.domain.model.valueobj.DeletedVO;
import sparrow.garcia.domain.model.valueobj.user.UserStatusVO;

import java.util.Date;

@Data
@TableName("tb_user")
public class UserPO {

    /**
     * 主键索引
     * */
    private String id;

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
     * 无
     * */
    private String password;

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
    private Integer userStatus;

    /**
     * 0为正常,1为注销
     * */
    private Integer deleted;

    /**
     * 默认当前时间
     * */
    private Date createdTime;

    /**
     *
     * */
    private Date updatedTime;

}
