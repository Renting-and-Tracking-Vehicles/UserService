package com.example.userservice.auth;

import com.example.userservice.model.RegisteredUserEntity;
import io.jsonwebtoken.Jwts;
import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {
    @Value("renting-and-tracking-app")
    private String APP_NAME;

    @Value("somesecret")
    public String SECRET;

    @Value("3600000")
    private int EXPIRES_IN;

    @Value("Authorization")
    private String AUTH_HEADER;

    private static final String AUDIENCE_WEB = "web";

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public String generateToken(String email){
        return Jwts.builder()
                .setIssuer(APP_NAME)
                .setSubject(email)
                .setAudience(generateAudience())
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, SECRET).compact();
    }

    private Date generateExpirationDate() {
        return new Date(new Date().getTime() + EXPIRES_IN);
    }

    private String generateAudience() {
        return AUDIENCE_WEB;
    }

    public String getToken(HttpServletRequest request){
        String authHeader = getAuthHeaderFromHeader(request);
        if(authHeader != null && authHeader.startsWith("Bearer ")) return authHeader.substring(7);
        return null;
    }

    public String getEmailFromToken(String token){
        String email;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            email = claims.getSubject();
        } catch (ExpiredJwtException ex){
            throw ex;
        } catch (Exception e){
            email = null;
        }
        return email;
    }

    public Date getIssuedAtDateFromToken(String token){
        Date issueAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (ExpiredJwtException ex){
            throw ex;
        } catch (Exception e){
            issueAt = null;
        }
        return issueAt;
    }

    public Date getExpirationDateFromToken(String token){
        Date expDate;
        try{
            final Claims claims = this.getAllClaimsFromToken(token);
            expDate = claims.getExpiration();
        } catch (ExpiredJwtException ex){
            throw ex;
        } catch (Exception e) {
            expDate = null;
        }
        return expDate;
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException ex){
            throw ex;
        } catch (Exception e){
            claims = null;
        }
        return claims;
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        RegisteredUserEntity registeredUser = (RegisteredUserEntity) userDetails;
        final String email = getEmailFromToken(token);
        final Date created = getIssuedAtDateFromToken(token);

        return (email != null &&
                email.equals(userDetails.getUsername()));
    }

    private String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTH_HEADER);
    }

    public int getExpiredIn(){
        return EXPIRES_IN;
    }


}
