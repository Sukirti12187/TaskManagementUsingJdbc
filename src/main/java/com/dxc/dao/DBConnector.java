package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskmanagement","root","7739");
			return con;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
		
			
}
		
		


		
	

