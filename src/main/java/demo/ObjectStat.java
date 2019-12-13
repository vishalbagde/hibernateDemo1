package demo;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import table.Country;
import table.Student;

public class ObjectStat {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(table.Student.class);
		configuration.addAnnotatedClass(table.Laptop.class);
		configuration.addAnnotatedClass(table.Address.class);
		configuration.addAnnotatedClass(table.Country.class);
		configuration.addAnnotatedClass(table.Course.class);

		// .addAnnotatedClass(Dept.class);

		SessionFactory sFactory = configuration.buildSessionFactory();

		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		
//		Country c=new Country();
//		c.setCountry_id(70);
//		c.setCountry_name("USA");
//		session.save(c);
		
		Student s=session.load(Student.class, 1);
		//System.out.println(s);
		
			
		
		
		tx.commit();
		
	}

	


}
