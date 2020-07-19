package org.zerock.social.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizationSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.zerock.social.handler.CustomOAuthSuccessHandler;
import org.zerock.social.security.CustomOAuthSecurityService;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomOAuthSecurityService customSecurityService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new CustomOAuthSuccessHandler();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("security config...............");

        http.authorizeRequests().antMatchers("/sample/mypage").hasRole("USER");

        http.formLogin();
        http.oauth2Login()

                .successHandler(authenticationSuccessHandler())
                .userInfoEndpoint()

                .userService(customSecurityService)

        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        log.info("congigure.........................");

        auth.inMemoryAuthentication().withUser("user1").password("$2a$10$suvYAqYDPnLqvfHcTfU57eTJ.kiYmAluCnvgbbOsjxOH9voQjQMj2")
                .roles("USER");

    }




}
