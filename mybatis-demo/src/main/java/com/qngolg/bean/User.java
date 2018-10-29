package com.qngolg.bean;

/**
 * @Author qiangl
 * Created by qgl on 2018/10/25.
 */
public class User {
     private Integer id;
     private String username;
     private String password;
     private Double account;

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public Double getAccount() {
          return account;
     }

     public void setAccount(Double account) {
          this.account = account;
     }
}
