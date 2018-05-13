package lukasziwon.hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import lukasziwon.hibernate.entity.User;

public class QueryUser {

	public static void main(String[] args) {
		 
		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(User.class)
										.buildSessionFactory();
				//create session
				Session session = factory.getCurrentSession();
				
		try  {					
					
					//start a transaction
					session.beginTransaction();
					
					//query user
					List<User> theUser= session.createQuery("from User s where s.last_name='Nowak' OR s.first_name='Lukasz'").getResultList();
					
					//display users
					System.out.println("\n\nUsers who have last_name of Nowak or have first_name of Lukasz: ");
					for (User tempUser: theUser)  {
						System.out.println(tempUser);
					}
					//commit a transaction
					session.getTransaction().commit();
					
					System.out.println("Done!!!");
					
					
					
		} finally  {
			factory.close();
		}

	}

}
