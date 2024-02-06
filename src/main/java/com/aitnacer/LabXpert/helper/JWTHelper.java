package com.aitnacer.LabXpert.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.aitnacer.LabXpert.utils.Constant.*;

@Component
public class JWTHelper {
    Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
    public String generateAccessToken(String userName,String role){
        return  JWT.create().withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRE_ACCESS_TOKEN))
                .withIssuer(ISSUER)
                .withClaim("role",role)
                .sign(algorithm);

    }
    public String generateRefreshToken(String userName){
        return  JWT.create().withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRE_REFRESH_TOKEN))
                .withIssuer(ISSUER)
                .sign(algorithm);

    }


}
