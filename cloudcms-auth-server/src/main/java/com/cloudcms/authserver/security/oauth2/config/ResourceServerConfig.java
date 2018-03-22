package com.cloudcms.authserver.security.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "my_rest_api";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .requestMatchers().antMatchers("/user/**")
                .and().authorizeRequests()
                .antMatchers("/user/**").hasAuthority("rest:access")
                //.antMatchers("/user/**").access("hasRole('ADMIN')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        /*http.csrf().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/oauth/token").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .anyRequest().authenticated()
              ;
        http.
                csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/hello", "/oauth/**").permitAll()
                .anyRequest().fullyAuthenticated();
                //.anyRequest().authenticated()
                .and()
                .httpBasic();*/
    }
}
