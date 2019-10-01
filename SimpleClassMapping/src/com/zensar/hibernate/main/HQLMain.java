//hibernate querry language (object orinted querry language)
package com.zensar.hibernate.main;

import java.sql.Array;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class HQLMain {

	public static void main(String[] args) {

		Configuration c = new Configuration().configure();

		SessionFactory f = c.buildSessionFactory();

		Session s = f.openSession();// represents database connection and light weight

		Transaction tx = s.beginTransaction();

		// jpa querry is used in hibernate

		// Query q = s.createQuery("from Product");

		// filtering a list using hql
		// Query q = s.createQuery("from Product p where p.price>40000 and
		// p.price<100000");

		// Query q = s.createQuery("from Product p where p.price between 40000 and
		// 100000");

		// Query q = s.createQuery("from Product p where p.brand like 'M%'");

		/*
		 * Query q = s.createQuery("from Product p where p.name like 'laptop'");
		 * 
		 * List<Product> products = q.getResultList(); 
		 * for (Product a : products) {
		 * System.out.println(a);
		 * 
		 * }
		 */
		/*Query q = s.createQuery("select p.name, p.price,p.brand from Product p");
		List<Object[]> objects = q.getResultList();
		for (Object[] a : objects) {
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);

			}

		}
		*/
		//max
		Query q = s.createQuery("select max(p.price) from Product p");
		Float maxPrice =(Float) q.getSingleResult();
		System.out.println(maxPrice);
		
		//min
		Query q1 = s.createQuery("select min(p.price) from Product p");
		Float minPrice =(Float) q1.getSingleResult();
		System.out.println(minPrice);
		
		//sum
		Query q2 = s.createQuery("select sum(p.price) from Product p");
		Double sumPrice =(Double) q2.getSingleResult();
		System.out.println(sumPrice);
		
		//avg
		Query q3 = s.createQuery("select avg(p.price) from Product p");
		Double avgPrice =(Double) q3.getSingleResult();
		System.out.println(avgPrice);
		
		//count
		Query q4 = s.createQuery("select count(p.price) from Product p");
		long countPrice =(Long) q4.getSingleResult();
		System.out.println(countPrice);
		
		
		//critaria
		
		/*Criteria cr = s.createCriteria(Product.class);
		List<Product> products = cr.list();
		 for (Product a : products) {
			 System.out.println(a);
			  }
		*/

		tx.commit();

		s.close();

	}

}
