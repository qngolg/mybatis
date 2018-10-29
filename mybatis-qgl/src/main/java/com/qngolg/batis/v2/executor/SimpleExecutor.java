package com.qngolg.batis.v2.executor;

import com.qngolg.batis.v2.config.Configuration;
import com.qngolg.batis.v2.config.MapperRegistor;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/29.
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T query(MapperRegistor.MapperData mapperData, Object params) {
        StateMentHandler handler = new StateMentHandler(configuration);
        return null;
    }
}
