package sparrow.garcia.domain.model.valueobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sparrow.garcia.domain.model.valueobj.user.UserStatusVO;

@AllArgsConstructor
@Getter
public enum DeletedVO {
    AVAILABLE(0,"正常"),DELETED(1,"已删除");
    private final Integer code;
    private final String inf;
    public DeletedVO getDeletedStatus(Integer code){
        switch (code){
            case 1 :
                return DELETED;
            case 0:
                return AVAILABLE;
            default:
                return AVAILABLE;
        }

    }
}
