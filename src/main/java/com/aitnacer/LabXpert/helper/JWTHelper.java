package com.aitnacer.LabXpert.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aitnacer.LabXpert.utils.Constant.*;

@Component
public class JWTHelper {
    Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
    public String generateAccessToken(String userName, List<String> roles){
        return  JWT.create().withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRE_ACCESS_TOKEN))
                .withIssuer(ISSUER)
                .withClaim("roles",roles)
                .sign(algorithm);

    }
    public String generateRefreshToken(String userName){
        return  JWT.create().withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRE_REFRESH_TOKEN))
                .withIssuer(ISSUER)
                .sign(algorithm);

    }
    public String extractTokenFromHeaderIfExists(String authorizationHeader){
        if(authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)){
            return  authorizationHeader.substring(BEARER_PREFIX.length());
        }
        return null;
    }
    public Map<String, String> getTokensMaps(String jwtAccessToken, String jwtRefreshToken){
        Map<String,String> idTokens = new HashMap<>();
        idTokens.put("accessToken",jwtAccessToken);
        idTokens.put("refrechToken",jwtRefreshToken);
        return  idTokens;
    }

}
