package com.cloudcms.authserver.dao;

import com.cloudcms.authserver.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository("userDao")
public interface UserDao {
    @ResultMap("userRoleMap")
    User getUserByUsername(@Param("username") String username);
}
