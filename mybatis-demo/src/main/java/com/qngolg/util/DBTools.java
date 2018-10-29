package com.qngolg.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/25.
 */
public class DBTools {

    public static SqlSessionFactory sessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("Mybatis.config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlsession
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
}
