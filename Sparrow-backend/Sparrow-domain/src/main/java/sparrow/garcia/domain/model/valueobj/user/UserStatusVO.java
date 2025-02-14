package sparrow.garcia.domain.model.valueobj.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatusVO {
    USER_BAN(1,"封禁"),USER_NORMAL(0,"正常");
    private final Integer code;
    private final String inf;
    public static UserStatusVO getUserStatus(Integer code){
        switch (code){
            case 1 :
                return USER_BAN;
            case 0:
                return USER_NORMAL;
            default:
                return USER_NORMAL;
        }

    }
}
