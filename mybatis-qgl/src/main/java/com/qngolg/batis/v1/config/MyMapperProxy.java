package com.qngolg.batis.v1.config;

import com.qngolg.batis.v1.session.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class MyMapperProxy implements InvocationHandler {

    private MySqlSession sqlSession;

    public MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getDeclaringClass().getName().equals(MyConfiguration.UserXmlMapper.namespace)){
            //通过interface的method名称 对应到xml中的 method对应的id 从而找到相应的sql
            String sql = MyConfiguration.UserXmlMapper.methodSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
        }
        return method.invoke(args);
    }
}
