package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main
{
		public static void main(String src[])
		{
			
			Dept d1 = new Dept();
			d1.setDept_no(102);
			d1.setDept_name("pure");
			d1.setLoc("surat");
			
			try
			{
			
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
					//.addAnnotatedClass(Dept.class);
			SessionFactory sFactory=configuration.buildSessionFactory();
			
			Session session=sFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(d1);
			tx.commit();
			
			}catch (Exception e) {
				System.out.println(e.fillInStackTrace().toString());	
			}
			
			
	}
}
	