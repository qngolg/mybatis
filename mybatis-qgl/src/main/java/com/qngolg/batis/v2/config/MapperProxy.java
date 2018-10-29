package com.qngolg.batis.v2.config;

import com.qngolg.batis.v2.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    //代理
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //根据方法名获取mapperData
        MapperRegistor.MapperData mapperData = sqlSession.
                getConfiguration().
                getMapperRegistor().
                get(method.getDeclaringClass().getName()+""+method.getName());
        if(null != mapperData){
            System.out.println(String.format("SQL [ %s ],param [ %s ]",mapperData.getSql(),args[0]));
            return sqlSession.selectOne(mapperData,String.valueOf(args[0]));
        }

        return method.invoke(args);
    }
}
