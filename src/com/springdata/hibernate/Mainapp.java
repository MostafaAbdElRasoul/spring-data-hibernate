package com.springdata.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

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
			/* ///update
			Client client = session.get(Client.class, id);
			client.setAge(45);
			client.setFullName("mmomomo");
			*/
			/*
			 * ///update
			Client client = new Client("mo salah", 30, "cairoo");
			client.setId(id);
			session.update(client);
			*/
			/*  //delete
			Client client = new Client();
			client.setId(id);
			session.delete(client);
			*/
			//List<Client> clients = 
			/*Query query =
					session.
					createQuery("from Client where id =:v1");
					//.list();
			//query.setFirstResult(0);
			//query.setMaxResults(2);
			query.setInteger("v1", 4);
			List<Client> clients = query.list();
			for (int i = 0; i < clients.size(); i++) {
				System.out.println(clients.get(i).getFullName()+" "+clients.get(i).getAge());
			}*/
			Query q1 = session.createQuery("select Max(id) from Client");
			Query q2 = session.createQuery("select Min(id) from Client");
			Query q3 = session.createQuery("select sum(id) from Client");
			Query q4 = session.createQuery("select avg(id) from Client");
			Query q5 = session.createQuery("select count(address) from Client");
			Query q6 = session.createQuery("select count(distinct address) from Client");
			System.out.println("Max : "+q1.list().get(0));
			System.out.println("Min : "+q2.list().get(0));
			System.out.println("sum : "+q3.list().get(0));
			System.out.println("avg : "+q4.list().get(0));
			System.out.println("count : "+q5.list().get(0));
			System.out.println("count distinct : "+q6.list().get(0));
			session.getTransaction().commit();
			//System.out.println(client.getFullName()+" "+client.getAge()+" "+client.getAddress());
			
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
