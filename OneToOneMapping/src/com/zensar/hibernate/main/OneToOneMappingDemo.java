package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMappingDemo {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure();
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Country country = new Country();
		country.setName("India");
		country.setPopulation(200000000l);
		country.setLanguage("Hindi");
		
		Flag flag =new Flag();
		flag.setFlagName("Bharat");
		flag.setFlagDescription("It is a tri color flag");
		
		//establishing relationship for one to one
		country.setFlag(flag);
		flag.setCountry(country);
		
		s.save(country);
		s.save(flag);
		
		
		tx.commit();
		s.close();
		System.exit(0);
	}

}
