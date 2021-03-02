package com.csp.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/oauth/token");
    }


    // JPA userService is used to provide authentication for logged in user.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // Authorization order should be from most restricted to less restricted roles
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers()
                .frameOptions().disable().and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs", "/**/health", "/v1/sso/signin").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);

    }

    // This method is used to encode the password for user. I have used NoOpPasswordEncoder which does not encode any password in real.
    // If you want encoded password to be store in DB you can use one of the most widely used BCryptPasswordEncoder instead of NoOpPasswordEncoder.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
