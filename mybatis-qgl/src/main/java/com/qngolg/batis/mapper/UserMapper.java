package com.qngolg.batis.mapper;


import com.qngolg.batis.bean.User;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public interface UserMapper {

    public User selectOne(int id);
}
