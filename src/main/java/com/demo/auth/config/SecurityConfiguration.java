package com.demo.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

import static org.springframework.security.config.http.SessionCreationPolicy.IF_REQUIRED;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ExpiredSessionStrategy expiredSessionStrategy;

    @Autowired
    private RedisIndexedSessionRepository sessionRepository;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // configure a auth event publisher
                .authenticationEventPublisher(new DefaultAuthenticationEventPublisher(applicationEventPublisher))
                .userDetailsService(userDetailsService);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                    .requestCache()
                    .requestCache(new NullRequestCache())
                .and()
                    .httpBasic()
                .and()
                    .sessionManagement()
                    .sessionFixation()
                    .migrateSession()
                    .sessionCreationPolicy(IF_REQUIRED)
                    .maximumSessions(1)
                    .maxSessionsPreventsLogin(false)
                    .expiredSessionStrategy(expiredSessionStrategy)
                    .sessionRegistry(sessionRegistry())
                .and()
                .and()
                    .headers()
                    .frameOptions()
                    .sameOrigin() //for H2 DB
                .and()
                    .csrf()
                    .disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry() {
        return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
