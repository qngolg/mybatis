package com.qngolg.batis.v1.config;

import com.qngolg.batis.v1.session.MySqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class MyConfiguration {



    public <T> T getMapper(Class<T> clazz, MySqlSession session) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},new MyMapperProxy(session));
    }

    /**
     * 模拟解析xml
     */
    static class UserXmlMapper{

        public static final String namespace = "com.qngolg.batis.mapper.UserMapper";

        public static final Map<String,String> methodSqlMapping = new ConcurrentHashMap<String, String>();

        static {
            methodSqlMapping.put("selectOne","select * from t_user where id = %d");
        }

    }

}
