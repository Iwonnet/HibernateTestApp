package lukasziwon.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lukasziwon.hibernate.entity.User;

public class MultipleUser {

	public static void main(String[] args) {
		 
		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(User.class)
										.buildSessionFactory();
				//create session
				Session session = factory.getCurrentSession();
				
		try  {					
					//create 4 user objects
					System.out.println("Creating 4 user objects ...");
					User tempUser1 = new User("Janek","Nowak","janN@gmail.com");
					User tempUser2 = new User("Michal","Kowalski","KowalskiM@gmail.com");
					User tempUser3 = new User("Grzegorz","Czok","grzegorzC@gmail.com");
					User tempUser4 = new User("Bruno","Poznanski","bpoznanski@gmail.com");
					
					//start a transaction
					session.beginTransaction();
					
					//save a user object
					System.out.println("Saving the users ...");
					session.save(tempUser1);
					session.save(tempUser2);
					session.save(tempUser3);
					session.save(tempUser4);
					
					//commit a transaction
					session.getTransaction().commit();
					
					System.out.println("Done!!!");
					
					
					
		} finally  {
			factory.close();
		}

	}

}
