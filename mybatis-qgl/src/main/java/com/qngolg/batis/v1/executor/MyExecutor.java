package com.qngolg.batis.v1.executor;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public interface MyExecutor {
   <T> T query(String sql, String paramter);
}
