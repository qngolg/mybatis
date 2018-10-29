package com.qngolg.batis.v2.session;


import com.qngolg.batis.v2.config.Configuration;
import com.qngolg.batis.v2.config.MapperProxy;
import com.qngolg.batis.v2.config.MapperRegistor;
import com.qngolg.batis.v2.executor.Executor;

import java.lang.reflect.Proxy;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class SqlSession {

    Configuration configuration;
    Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }




    /**
     * getMapper
     * @param clazz
     * @param <T>
     * @return
     */
    public  <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},new MapperProxy(this));
    }

    /**
     * 查询
     * @param params 入参
     * @param <T> 泛型
     * @return
     */
    public <T> T selectOne(MapperRegistor.MapperData mapperData, Object params){
        return executor.query(mapperData,params);
    }


    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }
}
