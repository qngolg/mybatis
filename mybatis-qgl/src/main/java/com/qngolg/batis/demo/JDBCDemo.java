package com.qngolg.batis.demo;


import com.qngolg.batis.bean.User;

import java.sql.*;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class JDBCDemo {


    public static void main(String[] args) {
            User user = selectOne(1);
        System.out.println(user);
    }


    public static User selectOne(int id){

        Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try {
            Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection(
                    "jdbc:mysql://192.168.150.137/USER?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "root@123"
            );
            connection.setAutoCommit(false);
            String sql = "select * from t_user where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
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

        return user;
    }

}
