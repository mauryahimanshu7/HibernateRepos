package com.zensar.hibernate.main;
import java.util.List;

/*
 * @descriptin: delete of records
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class MovieDeleteDemo {
	public static void main(String[] args) {
Configuration con = new Configuration().configure();
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session s= sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Movie m =s.get(Movie.class, 1);
		System.out.println(m.getTitle());
		System.out.println(m.getReleaseDate());
		
		List<Song> song = m.getSongs();
		for(Song so:song) {
			
			System.out.println(so);
			
		}
		if(m!=null) {
			s.delete(m);
		}else {
			System.out.println("Sorry! movie not found");
		}
		
		
		
		tx.commit();
		s.close();
	}

}
