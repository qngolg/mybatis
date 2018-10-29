package com.qngolg.demo;

import com.qngolg.bean.User;
import com.qngolg.mapper.UserMapper;
import com.qngolg.util.DBTools;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/25.
 */
public class UserService {

    public static void main(String[] args) {
        insertUser();
    }


    private static void insertUser(){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("aa");
        user.setPassword("bb");
        user.setAccount(100.0);
//        User user2 = new User();
//        user2.setUsername(null);
//        user2.setPassword("bb");
//        user2.setAccount(100.0);
        try {
            int a = mapper.insertUser(user);
            System.out.println("a " + a + " user: " + user.toString());
            session.selectList("");
            //user2 username为null
            //在session commit以后 则前面的insert已经插入 且不会回滚。
//            session.commit();
//            int b = mapper.insertUser(user2);
//            System.out.println("b " + b + " user: " + user.toString());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }

    }
}
