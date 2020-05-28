package com.touchcode.bugtrackersystem.service;



import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://database-2.ciuz4zdnjq5l.us-east-2.rds.amazonaws.com:3306/web_bug_tracker?useSSL=false&serverTimezone=UTC";
		String user = "admin";
		String pass = "Chai1234";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
						
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}



