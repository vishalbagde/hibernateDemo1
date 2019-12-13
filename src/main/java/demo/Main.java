package demo;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import table.*;

public class Main {
	public static void main(String src[]) {
		
		Address address = new Address(1, 899, "sachin", "sachin", "surat");
		Country country = new Country(1, "INDIA");
		Country country1 = new Country(2, "USA");
		
		Laptop l1 = new Laptop(103, "MAC AIR");

		ArrayList<Laptop> list = new ArrayList<Laptop>();
		list.add(new Laptop(101, "DELL"));
		list.add(new Laptop(102, "HP"));
		
		
		ArrayList<Course> courselist = new ArrayList<Course>();
		courselist.add(new Course(101, "BCA"));
		courselist.add(new Course(102, "MCA"));
		

		Student s1 = new Student(10, new StudentName("vishal", "Govind", "Bagde"), 23, address, list, country,courselist);

		try {

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

			session.save(address);
			session.save(country);
			session.save(country1);
			
			session.save(l1);

			session.save(list.get(0));
			session.save(list.get(1));
			
			session.save(courselist.get(0));
			session.save(courselist.get(1));
						
			session.save(s1);
			
			
			
			Student su1= session.get(Student.class,10);
			Collection<Laptop> l=su1.getLaptop();
			System.out.println(su1.toString());
			
			//fetch laptop in for student
			for(Laptop lp :l)
			{
				System.out.println(lp.toString());
			}
			
				
			tx.commit();
			
			
			Session session2=sFactory.openSession();
			tx.begin();
			
			Student su2 = session2.get(Student.class,10);
			System.out.println(su2);

			Student su3 = session.get(Student.class,10);
			System.out.println(su3);
	
			tx.commit();

			
			
			
			
			

		} catch (Exception e) {
			System.out.println(e.fillInStackTrace().toString());
		}

	}
}
