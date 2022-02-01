package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mainapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
		String username = "root";
		String password = "";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			
			
		}
	}

}
