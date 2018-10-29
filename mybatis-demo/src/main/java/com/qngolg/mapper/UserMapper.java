package com.qngolg.mapper;

import com.qngolg.bean.User;

import java.util.List;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/25.
 */
public interface UserMapper {

    int insertUser(User user);

    List<User> selectAllUser();
}
