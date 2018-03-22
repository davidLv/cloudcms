package com.cloudcms.authserver.security.password;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NoPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence password) {
        return password.toString();
    }

    @Override
    public boolean matches(CharSequence password, String encodedPassword) {
        return encodedPassword.equals(password.toString());
    }
}
