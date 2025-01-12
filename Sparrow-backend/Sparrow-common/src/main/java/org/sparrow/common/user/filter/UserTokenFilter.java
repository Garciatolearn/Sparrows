package org.sparrow.common.user.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sparrow.common.tools.JwtUtil;
import org.sparrow.common.tools.http.ServletHttpUtil;
import org.sparrow.common.user.core.UserContext;
import org.sparrow.common.user.entity.UserInfDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;

/***
 * 单机模式下自用
 */
@Component
public class UserTokenFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        //先判断是否能存在
        String userToken = request.getHeader("authorization");
        if(StringUtils.hasText(userToken)){
            UserInfDTO userInfDTO = JwtUtil.parseUserToken(userToken);
            UserContext.putUserContext(userInfDTO);
        }else {
            ServletHttpUtil.writeContextBody(response,HttpServletResponse.SC_UNAUTHORIZED,
                    MediaType.APPLICATION_NDJSON_VALUE, "该用户未授权");
            return;
        }
        try {
            chain.doFilter(request,response);
        } finally {
            UserContext.cleanUserContext();
        }
    }
}
