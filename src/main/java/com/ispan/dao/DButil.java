package com.ispan.dao;
//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
// 
//
//public class DButil {
//	private static final String USER = "sa";
//	private static final String PASSWORD = "sa123456";
//	private static final String DB_NAME = "travel_web";
//	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
//	
//	private static DataSource dataSource;
//	private static Connection conn;
//	private static final String  JNDI_LOOKUP_SERVICE = "java:/comp/env/jdbc/OrderOB";
//	static{
//		try {
//			Context context = new InitialContext();
//			Object lookup = context.lookup(JNDI_LOOKUP_SERVICE);
//			if(lookup != null){
//				dataSource =(DataSource)lookup;
//				
//			}else{
//				new RuntimeException("JNDI look up issue.");
//			}
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//	public static DataSource getDataSource(){
//		return dataSource;
//	}
//
//public static Connection getConnection() {
//	try {
//		Class.forName(JDBC_DRIVER);
//		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//	} catch (ClassNotFoundException | SQLException e) {
//		e.printStackTrace();
//	}
//	return conn;
//}
//}