package com.csp.authorization.model;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Smit.Jadhav on 14-10-2020.
 */

public class CustomJWTAccessTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalJWTInfo = new HashMap<>();
        UserDetailsDTO userDetailsDTO = (UserDetailsDTO) authentication.getPrincipal();
        additionalJWTInfo.put("email", userDetailsDTO.getEmail());
        additionalJWTInfo.put("userId", userDetailsDTO.getId());
        additionalJWTInfo.put("firstName", userDetailsDTO.getFirstName());
        additionalJWTInfo.put("lastName", userDetailsDTO.getLastName());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalJWTInfo);
        accessToken = super.enhance(accessToken, authentication);
        return accessToken;
    }

}
