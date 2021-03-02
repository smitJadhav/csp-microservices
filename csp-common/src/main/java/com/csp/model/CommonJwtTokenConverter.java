package com.csp.model;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

public class CommonJwtTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication auth = super.extractAuthentication(map);
        auth.setDetails(map);
        return auth;
    }
}
