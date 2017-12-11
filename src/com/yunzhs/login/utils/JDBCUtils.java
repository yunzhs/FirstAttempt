package com.yunzhs.login.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//1.����c3p0����Դ����
	private static ComboPooledDataSource cd = new ComboPooledDataSource();
	//2.��������Դ����
	public static DataSource getDataSource(){
		return cd;
	}
	//3.�������Ӷ���
	public static Connection getCon() throws SQLException{
		return cd.getConnection();
	}
}
