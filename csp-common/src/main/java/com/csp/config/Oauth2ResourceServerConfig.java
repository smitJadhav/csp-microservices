package com.csp.config;

import com.csp.model.CommonJwtTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
@ConditionalOnProperty(name = "oauth.resource.server.enable")
public class Oauth2ResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    public JwtAccessTokenConverter commonAccessTokenConverter(){
        CommonJwtTokenConverter converter = new CommonJwtTokenConverter();
        converter.setSigningKey(jwtSecret);
        return converter;
    }

    @Bean
    JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        JwtTokenStore jwtTokenStore = jwtTokenStore();
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(jwtTokenStore);
        tokenServices.setSupportRefreshToken(true);
        resources.tokenStore(jwtTokenStore).tokenServices(tokenServices);
    }
}
