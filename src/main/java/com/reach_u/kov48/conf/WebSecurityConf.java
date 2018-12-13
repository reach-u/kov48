package com.reach_u.kov48.conf;

import com.reach_u.kov48.rest.auth.AuthFilter;
import com.reach_u.kov48.service.SessionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private SessionCache sessionCache;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/favicon.ico",
                        "/v2/api-docs",
                        "/swagger-ui**",
                        "/swagger-resources/**",
                        "/webjars/springfox-swagger-ui/**",
                        "/api/1/login/**"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(new AuthFilter(sessionCache), UsernamePasswordAuthenticationFilter.class);
    }

}
