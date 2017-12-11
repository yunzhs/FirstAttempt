package com.yunzhs.login.dao;

import com.yunzhs.login.bean.User;
import com.yunzhs.login.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public User getByName(String username) throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        //2.执行sql
        String sql = "select * from users where uname=?";
        User user = runner.query(sql, new BeanHandler<User>(User.class),username);

        return user;
    }
}
