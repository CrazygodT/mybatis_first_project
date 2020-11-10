package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(@Param("id")int uid);

    User findByIdAndName(@Param("id") int id,@Param("userName") String name);

    int deleteById(int id);

    int addUser(User user);

    int updateById(User user);

    int insertGetId(User user);
}
