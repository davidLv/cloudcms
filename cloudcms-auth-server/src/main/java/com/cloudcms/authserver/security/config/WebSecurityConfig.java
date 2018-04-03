package com.cloudcms.authserver.security.config;

import com.cloudcms.authserver.security.password.NoPasswordEncoder;
import com.cloudcms.authserver.security.userdetailservice.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableWebFluxSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private CustomUserDetailService customUserDetailService;*/

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .antMatcher()*/
        http.csrf().disable()
            .httpBasic().disable()
            .authorizeRequests()
                    .antMatchers("/", "/login", "/assets/**", "/oauth/token", "/oauth/check_token").permitAll()
                    .antMatchers("/oauth/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                /*.and()
                    .oauth2Login()
                    .redirectionEndpoint()
                    .baseUri("/login")*/
                    ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().passwordEncoder(new NoPasswordEncoder()).withUser("user").password("password").roles("USER");
        auth.userDetailsService(userDetailsService());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
