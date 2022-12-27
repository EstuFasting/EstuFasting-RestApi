package edu.estu.estufastingrestapi.core.api.security;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.helper.ReflectionHelper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtTokenHelper {

    public static final String SCHEME = "Bearer";
    public static final String ISSUER = "EstuFasting";
    private static final int ONE_HOUR_IN_MILLIS = 3600000;
    private static final int JWT_EXPIRATION_HOUR = 48;
    @Value("${jwt.secret}")
    private String secret;

    @SneakyThrows(ExpiredJwtException.class)
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * @param user An object which has "String getUsername()" method
     */
    public String generateToken(Object user) {
        String username = ReflectionHelper.getFieldValueByGetter(user, "getUsername", String.class).orElse(null);
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_HOUR * ONE_HOUR_IN_MILLIS))
                .setIssuer(ISSUER)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
        return SCHEME + " " + token;
    }

    @SneakyThrows(JwtException.class)
    public void valid(Claims claims) {
        if (Optional.ofNullable(claims.getSubject()).isEmpty())
            throw new MalformedJwtException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_USERNAME);
        Date expiration = Optional.ofNullable(claims.getExpiration())
                .orElseThrow(() -> new MalformedJwtException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_EXPIRATION_DATE));
        if (!expiration.after(new Date())) throw new JwtException(MsgCode.SECURITY_RE_LOGIN_JWT_EXPIRED);
    }

}
