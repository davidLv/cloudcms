package org.cloudcms.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.cloudcms.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
//@Component("userDao")
public interface UserDao {
    @Select("select * from jo_user")
    @ResultMap("userMap")
    List<User> findAll();
}
