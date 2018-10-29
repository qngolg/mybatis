package com.qngolg.batis.v2.executor;

import com.qngolg.batis.bean.User;
import com.qngolg.batis.v2.config.Configuration;
import com.qngolg.batis.v2.config.MapperRegistor;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/29.
 */
public class StateMentHandler {

    private final Configuration configuration;

    private final ResultSetHandler resultSetHandler;

    private String params;

    public StateMentHandler(Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new ResultSetHandler(configuration);
    }

    public <E> E query(MapperRegistor.MapperData mapperData,Object params) throws SQLException {

        try {
            Connection connection = getConnection();
            PreparedStatement pst = connection.prepareStatement(mapperData.getSql(),
                    Integer.parseInt(String.valueOf(params)));
            //执行
            pst.execute();
            return resultSetHandler.handler(pst.getResultSet(),mapperData.getType());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    //jdbc 获取 连接
    private static Connection getConnection()   {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.150.137:3306/USER?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123";
        Connection connection = null;
        try {
            Class.forName(driver);
            connection =  DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
