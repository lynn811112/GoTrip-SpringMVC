package com.ispan.util;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnection {
	
	private static final String USER = "sa";
	private static final String PASSWORD = "sa123456";
	
	public static DataSource dataSource() {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(1433);
		ds.setUser(USER);
		ds.setPassword(PASSWORD);
		return ds;
	}

}
