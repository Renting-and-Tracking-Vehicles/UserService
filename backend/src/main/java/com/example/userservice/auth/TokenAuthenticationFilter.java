package com.example.userservice.auth;

import com.example.userservice.service.RegisteredUserServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private TokenUtils tokenUtils;
    private RegisteredUserServiceImpl userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String subject;
        String email;
        String authToken = tokenUtils.getToken(request);

        try {
            if(authToken != null){
                subject = tokenUtils.getSubjectFromToken(authToken);
                email = getEmail(subject);
                System.out.println(email);
                if(subject != null){
                    UserDetails userDetails = userService.loadUserByUsername(email);
                    if(tokenUtils.validateToken(authToken, userDetails)){
                        TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                        authentication.setToken(authToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        } catch (ExpiredJwtException ex) {
            throw ex;
        }
        filterChain.doFilter(request, response);
    }

    private String getEmail(String tokenSubject){
        String[] pomArr = tokenSubject.split(" ");
        String[] emailPom = pomArr[0].split("=");
        return emailPom[1].substring(0, emailPom[1].length());
    }
}
