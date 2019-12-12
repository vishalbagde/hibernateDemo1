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
			d1.setDept_no(104);
			d1.setDept_name("pure");
			d1.setLoc("surat");
			
			Student s1=new Student(1,"vishal",23);
			Student s2;
			try
			{
				
				
			Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class);
					//.configure("hibernate.cfg.xml");
			//.addAnnotatedClass(Dept.class);
			
			SessionFactory sFactory=configuration.buildSessionFactory();
			
			Session session=sFactory.openSession();
			Transaction tx=session.beginTransaction();
			s2 = session.get(Student.class, 1);
			System.out.println(s2);
			tx.commit();
			
			}catch (Exception e) {
				System.out.println(e.fillInStackTrace().toString());	
			}
			
			
	}
}
	