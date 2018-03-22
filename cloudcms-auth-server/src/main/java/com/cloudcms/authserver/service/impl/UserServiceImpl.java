package com.cloudcms.authserver.service.impl;

import com.cloudcms.authserver.bean.User;
import com.cloudcms.authserver.dao.UserDao;
import com.cloudcms.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
