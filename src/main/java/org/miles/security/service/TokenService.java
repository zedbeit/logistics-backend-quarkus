package org.miles.security.service;

import java.util.Set;

import javax.enterprise.context.RequestScoped;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.jwt.build.Jwt;
import io.vertx.core.json.JsonObject;

@RequestScoped
public class TokenService {
    Logger log = LoggerFactory.getLogger(TokenService.class);

    public JsonObject generateToken(String email, Set<String> roles) {

        JsonObject object = new JsonObject();
        long expiresAt = 300L;

        String token = Jwt.issuer("DEEHAZ")
            .upn(email)
            .preferredUserName(email)
            .subject(email)
            .groups(roles)
            .expiresIn(expiresAt)
            .sign();
    
        object.put("accessToken", token);
        object.put("expiresAt", expiresAt);

        log.info("Token generated {}", token);
        
        return object;
    }
}
