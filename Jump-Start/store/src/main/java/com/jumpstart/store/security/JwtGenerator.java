package com.jumpstart.store.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jumpstart.store.config.AppProperties;

import java.util.Date;

@Component
public class JwtGenerator {

  @Autowired
  private AppProperties appProperties;

  public String generateToken(Authentication authentication) {
    String username = authentication.getName();
    Date currentDate = new Date();
    Date expireDate = new Date(currentDate.getTime() + appProperties.getAuth().getTokenExpirationMsec());

    String token = Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(expireDate)
        .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
        .compact();
    return token;
  }

  public String getUsernameFromJWT(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(appProperties.getAuth().getTokenSecret())
        .parseClaimsJws(token)
        .getBody();
    return claims.getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(token);
      return true;
    } catch (Exception ex) {
      throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
    }
  }
}
