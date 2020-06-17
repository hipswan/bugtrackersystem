package com.touchcode.bugtrackersystem.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://ec2-52-44-55-63.compute-1.amazonaws.com:5432/ds38vdmopol3g";
		String user = "epepmctxaqrrwv";
		String pass = "09bcccb037935ee4434c822e1d8c4fab4643027d4f1cb73f4a5d2268e9f92301";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!!!");

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
