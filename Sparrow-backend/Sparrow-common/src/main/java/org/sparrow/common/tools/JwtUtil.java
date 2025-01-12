package org.sparrow.common.tools;

import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.*;
import org.sparrow.common.user.entity.UserInfDTO;

import java.time.LocalDateTime;
import java.util.Date;

public class JwtUtil {

    private static final String AUTHORIZATION_TOKEN_PREFIX = "bearer ";

    private static final String SECRET_KEY = "密钥就是密钥";

    private static final long EXPIRATION = 600;


    public static String createUserToken(UserInfDTO userInfDTO){
        String tokenString = Jwts.builder()
                .signWith(SignatureAlgorithm.ES256, SECRET_KEY)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION * 1000L))
                //图方便用subject主题,正规就用Claims字段来负责..
                .setSubject(JSON.toJSONString(userInfDTO))
                .compact();
        return AUTHORIZATION_TOKEN_PREFIX + tokenString;
    }

    public static UserInfDTO parseUserToken(String token){
        String user = token.subSequence(0, AUTHORIZATION_TOKEN_PREFIX.length()).toString();
        Jwt<Header, Claims> headerClaimsJwt = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJwt(user);
        Claims body = headerClaimsJwt.getBody();
        Date expiration = body.getExpiration();
        if (expiration.before(new Date())){
            String userInfoString = body.getSubject();
            UserInfDTO userInfDTO = JSON.parseObject(userInfoString, UserInfDTO.class);
            return userInfDTO;
        }
        return null;
    }
}
