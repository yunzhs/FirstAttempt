package com.yunzhs.login.service;

import com.yunzhs.login.bean.User;
import com.yunzhs.login.dao.UserDao;

import java.sql.SQLException;

public class Accountverify {
    public boolean judgeUser(String username) throws SQLException {
        //1.依赖dao
        UserDao dao = new UserDao();
        //2.调用dao的查询方法
        User user = dao.getByName(username);
        //3.判断用户是否已经存在
        if(user==null){
            //用户不存在
            return true;
        }

        return false;
    }
}
