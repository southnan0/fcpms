package com.czn.fcpms.common;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class TokenUtil {

    private static  Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(String audience){

        String jws = Jwts.builder()
                .setSubject("token")
                .setAudience(audience)
                .setIssuedAt(new Date())
                .setNotBefore(new Date())
                .setExpiration(new Date(new Date().getTime()+10*60*1000))
                .signWith(key).compact();
        return jws;
    }

    public static Jws parseToken(String jwsToken){
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws;
        }catch (JwtException jwtException){
            jwtException.printStackTrace();
        }
        return null;
    }
}
