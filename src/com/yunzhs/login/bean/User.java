package com.yunzhs.login.bean;

import java.io.Serializable;

public class User implements Serializable{
    private String usernaem;
    private String password;

    public User() {
    }

    public String getUsernaem() {
        return usernaem;
    }

    public void setUsernaem(String usernaem) {
        this.usernaem = usernaem;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
