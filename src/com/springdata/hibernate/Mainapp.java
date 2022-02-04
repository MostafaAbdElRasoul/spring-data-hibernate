package com.springdata.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.springdata.hibernate.model.Client;
import com.springdata.hibernate.model.Data;
import com.springdata.hibernate.model.Person;

public class Mainapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration ()
        						.configure("hibernate.cfg.xml")
        						.addAnnotatedClass(Person.class)
        						.addAnnotatedClass(Data.class)
        						.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();

		int id = 1;
		try {
			session.beginTransaction();
			/*
			 * PERSIST
			Person person = new Person();
			person.setName("mostaa");
			
			Data data = new Data();
			data.setAge("24");
			session.save(person);
			data.setPerson(person);
			
			session.save(data);
			
*/
			/*
			 * Remove
			Data data = new Data();
			data.setId(2);
			Data d = session.get(Data.class, data.getId());
			System.out.println("Name : "+d.getPerson().getName());
			System.out.println("Age : "+d.getAge());
		

			session.delete(d);
			*/
			/*
			 * Merge
			Data data = new Data();
			data.setId(2);
			Data d = session.get(Data.class, data.getId());
			System.out.println("Name : "+d.getPerson().getName());
			System.out.println("Age : "+d.getAge());
			d.getPerson().setName("mosta");
			d.setAge("19");
			 */
			Person p = new Person();
			p.setId(1);
			Person person = session.get(Person.class, p.getId());
			session.delete(person);
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
		/*
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
		*/
		/*
		Criteria c = session.createCriteria(Client.class);
		//c.setFirstResult(0);
		//c.setMaxResults(4);
		//c.add(Restrictions.between("id", (long)4, (long)8));
		//c.add(Restrictions.isNull("address"));
		//c.add(Restrictions.like("fullName", "o", MatchMode.ANYWHERE));
		//Long [] ids = {(long)4,(long)8,(long)9};
		//c.add(Restrictions.in("id", ids));
		/*
		Criterion c1 =Restrictions.eq("address", "egy");
		Criterion c2 = Restrictions.eq("fullName", "momo");
		LogicalExpression exp = Restrictions.and(c1, c2);
		c.add(exp);
		*/
		//c.setProjection(Projections.min("id"));
		//c.setProjection(Projections.sum("id"));
		//c.setProjection(Projections.avg("id"));
		//c.setProjection(Projections.count("address"));
		
		/*c.setProjection(Projections.countDistinct("address"));
		
		List<Client> clients = c.list();
		System.out.println("  : "+clients.get(0));
		session.getTransaction().commit();
		/*
		for (int i = 0; i < clients.size(); i++) {
			System.out.println(clients.get(i).getFullName()+" "+clients.get(i).getAge());
		}
		//System.out.println(client.getFullName()+" "+client.getAge()+" "+client.getAddress());
		*/
	}

}
