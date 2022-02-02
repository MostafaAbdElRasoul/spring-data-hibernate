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
		/*
		// client 1
		Client client1 = new Client("adsadaaasad", 25, "Menia matay");
		//client1.setId(1);
		// client 2
		Client client2 = new Client("adsadsdddddddddad", 25, "Menia matay");
		//client2.setId(2);
		// client 3
		Client client3 = new Client("adsad", 25, "Menia matay");
		//client3.setId(3);
		*/
		long id = 1;
		try {
			session.beginTransaction();
			Client client = session.get(Client.class, id);

			session.getTransaction().commit();
			System.out.println(client.getFullName()+" "+client.getAge()+" "+client.getAddress());
			
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
