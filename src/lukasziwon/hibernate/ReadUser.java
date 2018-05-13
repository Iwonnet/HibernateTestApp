package lukasziwon.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lukasziwon.hibernate.entity.User;

public class ReadUser {

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
					User tempUser = new User("Ala","Nowak","AlaNowak@gmail.com");
					
					
					//start a transaction
					session.beginTransaction();
					
					//save a user object
					System.out.println("Saving the user ...");
					System.out.println(tempUser);
					session.save(tempUser);
					
					
					//commit a transaction
					session.getTransaction().commit();
					
					//find out what the primary key is for new user ?
					System.out.println("The new user Id is : "+ tempUser.getId());
					
					//get a new session and start a transaction
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					//retrieve student based on the id: primary key
					System.out.println("\nGetting user with id: "+tempUser.getId());
					
					User myUser = session.get(User.class, tempUser.getId());
					
					System.out.println("Get complete: "+ myUser);
					
					//commit the transaction
					session.getTransaction().commit();
					
					
					
					System.out.println("Done!!!");
					
					
					
		} finally  {
			factory.close();
		}

	}

}
