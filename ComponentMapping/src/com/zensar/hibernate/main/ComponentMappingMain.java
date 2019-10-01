package com.zensar.hibernate.main;
// presists has a mapping
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {
	public static void main(String[] args) {

		Configuration c = new Configuration().configure();

		SessionFactory f = c.buildSessionFactory();

		Session s = f.openSession();

		Transaction tx = s.beginTransaction();

		Name name = new Name();
		name.setFirstName("Himanshu");
		// name.setMiddleName("Kumar");
		name.setLastName("Maurya");

		try {
			File photo = new File("./resources/customer.jpg");

			Customer cu = new Customer();
			cu.setCustomerId(6);
			cu.setCustomerName(name);
			cu.setAge(30);
			cu.setGender("male");
			cu.setAddress("mumbai");
			cu.setBirthDate(LocalDate.of(1997, 11, 5));
			//uploding a image
			FileInputStream fin = new FileInputStream(photo);

			Blob customerPhoto = BlobProxy.generateProxy(fin, photo.length());
			cu.setProfilePhoto(customerPhoto);
			
			//uploding a file
			File file2= new File("./resources/customerInfo.txt");
			FileReader fr = new FileReader(file2);
			Clob description = ClobProxy.generateProxy(fr, file2.length());
			cu.setDescription(description);
			
			s.save(cu);
			
			
			

			tx.commit();
			s.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
