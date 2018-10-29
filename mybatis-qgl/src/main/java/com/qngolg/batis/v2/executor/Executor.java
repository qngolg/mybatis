package com.qngolg.batis.v2.executor;

import com.qngolg.batis.v2.config.MapperRegistor;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public interface Executor {
    public <T> T query(MapperRegistor.MapperData mapperData ,Object params);
}
