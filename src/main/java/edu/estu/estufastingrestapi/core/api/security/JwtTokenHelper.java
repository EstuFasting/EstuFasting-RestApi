package edu.estu.estufastingrestapi.core.api.security;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtTokenHelper {

    private static final String SCHEME = "Bearer";
    private final UserService userService;
    @Value("${jwt.secret}")
    private String secret;

    @SneakyThrows(ExpiredJwtException.class)
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public String generateToken(User user) {
        final int JWT_EXPIRATION_HOUR = 48;
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_HOUR * 3600000)) // 48 hours
                .setIssuer("CosmicDust19")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .claim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
        return SCHEME + " " + token;
    }

    @SneakyThrows(JwtException.class)
    public void valid(String scheme, String token) {
        if (!Objects.equals(scheme, SCHEME))
            throw new MalformedJwtException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_SCHEME);
        Optional.ofNullable(getClaim(token, Claims::getSubject)).orElseThrow(() -> new MalformedJwtException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_USERNAME));
        Date expiration = Optional.ofNullable(getClaim(token, Claims::getExpiration)).orElseThrow(() -> new MalformedJwtException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_EXPIRATION_DATE));
        //userService.findByUserName(userName).orElseThrow(() -> new MalformedJwtException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_USERNAME_NOT_FOUND));
        if (!expiration.after(new Date())) throw new JwtException(MsgCode.SECURITY_RE_LOGIN_JWT_EXPIRED);
    }

}
