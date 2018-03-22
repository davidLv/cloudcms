package com.cloudcms.authserver.security.userdetailservice;

import com.cloudcms.authserver.bean.User;
import com.cloudcms.authserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CustomUserDetailService implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        log.info("username is {} and authorities are {}", username, authorities.toString());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), "{MD5}" + user.getPassword(), authorities);
        //return new org.springframework.security.core.userdetails.User(user.getUsername(), "{MD5}" + user.getPassword(), authorities);
    }
}
