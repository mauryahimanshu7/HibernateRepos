package com.zensar.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;

public class Inheritancemain {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure();
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session s= sf.openSession();
		
		Transaction tx= s.beginTransaction();
		
		Employee e = new Employee();
		
		e.setName("himanshu");
		e.setJoinDate(LocalDate.of(2019, 5, 12));
		e.setSalary(7000);
		
		s.save(e);
		
		WageEmp we = new WageEmp();
		we.setName("chitru");
		we.setJoinDate(LocalDate.of(2019, 3, 24));
		we.setRate(150);
		we.setHours(8);
		we.setSalary(7600);
		
		s.save(we);
		
		
		tx.commit();
		s.close();

	}

}
