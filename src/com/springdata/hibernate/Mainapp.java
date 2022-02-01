package com.springdata.hibernate;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Client;

public class Mainapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration ()
        						.configure("hibernate.cfg.xml")
        						.addAnnotatedClass(Client.class)
        						.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		Client client = new Client();
		client.setId(1);
		client.setFullName("Mostafa ado");
		client.setAge(25);
		client.setAddress("Menia matay");
		
		try {
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			session.close();
		}
		
		
		
		
		
		
		
		
		
		
		/*
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
		*/
	}

}
