package com.qngolg.batis.v2.config;


/**
 * @Author qiangl
 * Created by qgl on 2018/10/27.
 */
public class Configuration {

    private String scanPath;
    private MapperRegistor mapperRegistor;

    public Configuration scanPath(String scanPath){
        this.scanPath = scanPath;
        return this;
    }

    public void build() {
        if(null == scanPath || scanPath.length() < 1){
            throw new RuntimeException("scan path is required .");
        }
    }
    public Configuration(MapperRegistor mapperRegistor) {
        this.mapperRegistor = mapperRegistor;
    }

    public MapperRegistor getMapperRegistor() {
        return mapperRegistor;
    }

    public void setMapperRegistor(MapperRegistor mapperRegistor) {
        this.mapperRegistor = mapperRegistor;
    }

    public String getScanPath() {
        return scanPath;
    }

    public void setScanPath(String scanPath) {
        this.scanPath = scanPath;
    }
}
