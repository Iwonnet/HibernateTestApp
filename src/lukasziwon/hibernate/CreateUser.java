package lukasziwon.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lukasziwon.hibernate.entity.User;

public class CreateUser {

	public static void main(String[] args) {
		 
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try  {
			//use the session object to save Java object
			
			//create a user object
			System.out.println("Creatin new user object ...");
			User tempUser = new User("Lukasz","Iwon","nowiluk@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save a user object
			System.out.println("Saving the user ...");
			session.save(tempUser);
			
			//commit a transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
			
		} finally  {
			factory.close();
		}
	}

}
