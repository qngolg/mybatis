package com.qngolg.batis.v1.executor;

import com.qngolg.batis.bean.User;

import java.sql.*;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class MySimpleExecutor implements MyExecutor {
    public <T> T query(String sql, String paramter) {
        Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try {
            Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection(
                    "jdbc:mysql://192.168.150.137:3306/USER?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "root@123"
            );
            connection.setAutoCommit(false);
            //采坑 String preSql = String.format(sql,paramter); paramter没用Integer.parseInt(paramter)就报错了
            String preSql = String.format(sql,Integer.parseInt(paramter));
            statement = connection.prepareStatement(preSql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAccount(rs.getDouble(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return (T) user;
    }
}
