//package com.qngolg.util;
//
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.SqlSessionFactory;
//
//import javax.sql.DataSource;
//
///**
// * @Author qiangl
// * Created by qgl on 2018/10/25.
// */
//public class DBJavaUtil {
//
//
//    private static SqlSessionFactory sessionFactory;
//
//    static {
//        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(BlogMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//
//    }
//}
