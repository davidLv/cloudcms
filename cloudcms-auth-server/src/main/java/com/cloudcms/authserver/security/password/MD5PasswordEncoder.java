package com.cloudcms.authserver.security.password;

import com.cloudcms.authserver.utils.MD5Utils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MD5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence password) {
        return MD5Utils.encode((String)password);
    }

    @Override
    public boolean matches(CharSequence password, String encodedPassword) {
        return encodedPassword.equals(MD5Utils.encode((String)password));
    }
}
