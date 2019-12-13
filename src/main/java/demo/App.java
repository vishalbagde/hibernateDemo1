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

public class App {
	
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
			
			Country c=new Country();
			
			int b=1;
			Query q = session.createQuery("select country_id,country_name from Country where country_id > :b ");
			q.setParameter("b", b);
			List<Object[]> list =q.list();
			
			for(Object[] clist:list)
			{
				System.out.println(clist[0]+" : "+clist[1]);
			}
			
		
			
			SQLQuery sql = session.createSQLQuery("select country_id from country");
			sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			
			
			List<Country> slist = sql.list();
			
			for(Object o:slist)
			{
				Map p=(Map)o;
				System.out.println(p.get("country_id"));
			
			}
			
			tx.commit();

			
			
			
			
			


		
	}

}
