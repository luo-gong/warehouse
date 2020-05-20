package lg.cn.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    @Value("${timeInterval}")
    public long timeInterval;

    @Value("${jwt.signingKey}")
    public String signingKey;

    public String HS256(Map<String, Object> map) {
        Assert.notNull(map.get("uid"));
        Assert.notNull(map.get("username"));
        long systemTime = System.currentTimeMillis() + timeInterval;
        System.out.println("timeInterval>>>>" + timeInterval);
        System.out.println("systemTime>>>>" + systemTime);
        JwtBuilder jwtBuilder =
                Jwts.builder()
                        .signWith(SignatureAlgorithm.HS256, signingKey)
                        .setId(map.get("uid").toString())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(systemTime))
                        .claim("username", map.get("username"));
        return jwtBuilder.compact();
    }

    public Object getToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token).getBody();
        return claims.get("username");
    }
}
