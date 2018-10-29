package com.qngolg.batis.v1;

import com.qngolg.batis.bean.User;
import com.qngolg.batis.mapper.UserMapper;
import com.qngolg.batis.v1.config.MyConfiguration;
import com.qngolg.batis.v1.executor.MySimpleExecutor;
import com.qngolg.batis.v1.session.MySqlSession;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class MainV1 {

    public static void main(String[] args) {

        MySqlSession sqlSession = new MySqlSession(new MyConfiguration(),
                new MySimpleExecutor());
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectOne(1);
        System.out.println(user);

    }
}
