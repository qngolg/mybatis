package com.qngolg.batis.v1.session;

import com.qngolg.batis.v1.config.MyConfiguration;
import com.qngolg.batis.v1.executor.MyExecutor;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class MySqlSession {

    private MyConfiguration configuration;
    private MyExecutor executor;

    public MySqlSession(MyConfiguration configuration, MyExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 获取Mapper
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }


    public <T> T selectOne(String sql,String paramter){
        return  executor.query(sql,paramter);
    }

}
