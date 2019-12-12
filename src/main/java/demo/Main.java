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
			
			
			ArrayList<Laptop> list =new ArrayList<Laptop>();
			list.add(new Laptop(101,"DELL"));
			list.add(new Laptop(102,"HP"));
			
			
			Student s1=new Student(10, new StudentName("vishal","Govind","Bagde"), 23,address);
									
			try
			{
		
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(table.Student.class);
			configuration.addAnnotatedClass(table.Laptop.class);
			configuration.addAnnotatedClass(table.Address.class);

			//.addAnnotatedClass(Dept.class);
			
			SessionFactory sFactory=configuration.buildSessionFactory();
			
			Session session=sFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			//session.save(list.get(0));
			//session.save(list.get(1));
			session.save(address);
			session.save(s1);
			
			tx.commit();
			
			}catch (Exception e) {
				System.out.println(e.fillInStackTrace().toString());	
			}
			
			
	}
}
	