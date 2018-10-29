package com.qngolg.batis.v2.config;

import com.qngolg.batis.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/29.
 */
public class MapperRegistor {


    //存放方法名和sql的容器
    public static final Map<String,MapperData> methodSqlMapping = new HashMap<String, MapperData>();

    //取巧
    public MapperRegistor(){
        methodSqlMapping.put("com.qngolg.batis.mapper.UserMapper.selectOne",
                new MapperData("select * from t_user where id = %d",User.class));
    }

    public MapperData get(String nameSpace){
        return methodSqlMapping.get(nameSpace);
    }



    public class MapperData<T> {

        //sql语句
        private String sql;
        //返回值类型
        private Class<T> type;

        public MapperData(String sql, Class<T> type) {
            this.sql = sql;
            this.type = type;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getType() {
            return type;
        }

        public void setType(Class<T> type) {
            this.type = type;
        }
    }
}
