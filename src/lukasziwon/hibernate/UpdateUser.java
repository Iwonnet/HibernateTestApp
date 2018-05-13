package lukasziwon.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lukasziwon.hibernate.entity.User;

public class UpdateUser {

	public static void main(String[] args) {
		 
		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(User.class)
										.buildSessionFactory();
				//create session
				Session session = factory.getCurrentSession();
				
		try  {		
				int userID =1;
			
					//get a new session and start a transaction
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					//retrieve student based on the id: primary key
					System.out.println("\nGetting user with id: "+ userID);
					
					User myUser = session.get(User.class, userID);
					
					System.out.println("Updating users ... ");
					myUser.setFirst_name("Pasza");
					
					//commit the transaction
					session.getTransaction().commit();
					
					
					
					System.out.println("Done!!!");
					
					
					
		} finally  {
			factory.close();
		}

	}

}
