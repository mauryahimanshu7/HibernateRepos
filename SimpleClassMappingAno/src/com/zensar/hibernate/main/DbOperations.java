package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		// singleton and heavy weight session factory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession();// represents database connection and light weight
		Transaction tx = s.beginTransaction();
		// insert new record
		Product p = s.get(Product.class, 1001);


		if (p != null) {
			System.out.println("Product not found");
		} else {
			System.out.println(p);
		}
		// update record
		/*p = s.get(Product.class, 1002);

		if (p != null) {
			p.setPrice(p.getPrice()+2000);
			s.update(p);
		} else {
			System.out.println("Product not found");
		}
		*/
		//delete record
		p = s.get(Product.class, 1007);
		if(p!=null) {
			s.delete(p);
		}
		tx.commit();
		s.close();

	}

}
