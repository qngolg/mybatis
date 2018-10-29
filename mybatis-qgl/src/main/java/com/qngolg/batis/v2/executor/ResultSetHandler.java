package com.qngolg.batis.v2.executor;

import com.qngolg.batis.v2.config.Configuration;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/29.
 */
public class ResultSetHandler {

    private final Configuration configuration;

    public ResultSetHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    public <E> E handler(ResultSet rs,Class type) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Object resultObj = new DefaultObjectFactory().create(type);
        if(rs.next()){
            int i = 0;
            for(Field field:resultObj.getClass().getDeclaredFields()){
                setValue(resultObj,field,rs,i);
            }
        }
        return (E) resultObj;

    }

    private void setValue(Object resultObj, Field field, ResultSet rs, int i) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {

        Method setMethod = resultObj.getClass().getMethod("set" + upperCapital(field.getName()),field.getType());
        setMethod.invoke(resultObj,getResult(field,rs));
    }

    private Object getResult(Field field, ResultSet rs) throws SQLException {
        //bean属性的名字必须和数据库column的名字一样 TODO mybatis的typehandler没做
        Class<?> type = field.getType();
        if(Integer.class == type){
            return rs.getInt(field.getName());
        }
        if(String.class == type){
            return rs.getString(field.getName());
        }
        if(Double.class == type){
            return rs.getDouble(field.getName());
        }
        return rs.getString(field.getName());
    }

    private String upperCapital(String name) {
        String first = name.substring(0,1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }
}
