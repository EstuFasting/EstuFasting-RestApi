package edu.estu.estufastingrestapi.core.api.security;

import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.GrantedAuthorityMapper;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenHelper jwtTokenHelper;
    private final UserService userService;
    private final GrantedAuthorityMapper grantedAuthorityMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.substring(JwtTokenHelper.SCHEME.length() + 1);
        jwtTokenHelper.valid(token);
        String username = jwtTokenHelper.getClaim(token, Claims::getSubject);

        UserAuthProjection user = userService.getUserAuthoritiesByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, grantedAuthorityMapper.map(user.getRoles()));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

}