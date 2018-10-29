package com.qngolg.batis.v2;

import com.qngolg.batis.bean.User;
import com.qngolg.batis.mapper.UserMapper;
import com.qngolg.batis.v2.config.Configuration;
import com.qngolg.batis.v2.config.MapperRegistor;
import com.qngolg.batis.v2.executor.SimpleExecutor;
import com.qngolg.batis.v2.session.SqlSession;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/29.
 */
public class MainV2 {

    public static void main(String[] args) {
        start();
    }

    private static void start(){

        Configuration configuration = new Configuration(new MapperRegistor());
        configuration.setScanPath("com.qngolg.batis.mapper");
        configuration.build();
        SqlSession sqlSession = new SqlSession(configuration,new SimpleExecutor(configuration));
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectOne(1);
        System.out.println(user);
    }
}
