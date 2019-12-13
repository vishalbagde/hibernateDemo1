package demo;




import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import table.*;

public class Main
{
		public static void main(String src[])
		{
		
			Address address =new Address(1,899, "sachin", "sachin", "surat");
			Country country =new Country(1,"INDIA");
			Country country1 =new Country(2,"USA");
			
			Laptop l1=new Laptop(103,"MAC AIR");
			
			ArrayList<Laptop> list =new ArrayList<Laptop>();
			list.add(new Laptop(101,"DELL"));
			list.add(new Laptop(102,"HP"));
						
			
			Student s1=new Student(10, new StudentName("vishal","Govind","Bagde"), 23,address,list,country);
									
			try
			{
		
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(table.Student.class);
			configuration.addAnnotatedClass(table.Laptop.class);
			configuration.addAnnotatedClass(table.Address.class);
			configuration.addAnnotatedClass(table.Country.class);
			
			//.addAnnotatedClass(Dept.class);
			
			SessionFactory sFactory=configuration.buildSessionFactory();
			
			Session session=sFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.save(address);
			session.save(country);
			session.save(country1);
	
			session.save(l1);
			
			session.save(list.get(0));
			session.save(list.get(1));
			
			session.save(s1);
			
			tx.commit();
			
			}catch (Exception e) {
				System.out.println(e.fillInStackTrace().toString());	
			}
			
			
	}
}
	