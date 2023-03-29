package com.masai.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class DBUtils {
	
	public static Connection connectToDatabase() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			ResourceBundle rb = ResourceBundle.getBundle("DBDetails");
			
			final String URL = rb.getString("url");
			final String USERNAME = rb.getString("username");
			final String PASSWORD = rb.getString("password");
			
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			return con;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	public static boolean isResultSetEmpty(ResultSet r) {
		try {
			if(!r.isBeforeFirst() && r.getRow() == 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
