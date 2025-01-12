package org.sparrow.common.user.core;

import org.sparrow.common.user.entity.UserInfDTO;

public class UserContext {

    public static final ThreadLocal<UserInfDTO> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void cleanUserContext(){
        USER_THREAD_LOCAL.remove();
    }

    public static void putUserContext(UserInfDTO userInfDTO){
        USER_THREAD_LOCAL.set(userInfDTO);
    }
}
