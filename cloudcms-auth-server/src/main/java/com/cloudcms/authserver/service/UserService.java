package com.cloudcms.authserver.service;

import com.cloudcms.authserver.bean.User;

public interface UserService {
    User getUserByUsername(String username);
}
