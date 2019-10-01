package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

/*
 * @author: Himanshu Maurya
 * @creation-date: 28/9/19
 * @description: one to many mapping . important for project . the one entity is reflected onto other tables 
 */
public class OneToManyMappingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration con = new Configuration().configure();
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session s= sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		//creating song objects
		Song s1 = new Song();
		s1.setSongName("aabbcc");
		Song s2 = new Song();
		s2.setSongName("ababac");
		Song s3 = new Song();
		s3.setSongName("xyassf");
		
		//object of movie
		Movie movie = new Movie();
		movie.setTitle("ddlj");
		movie.setReleaseDate(LocalDate.of(2000, 7, 12));
		
		//setting movieid in song table 
		s1.setMovie(movie);
		s2.setMovie(movie);
		s3.setMovie(movie);
		
		//creating a list of objects for the entry into movie object 
		List<Song> songs = new ArrayList();
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);	
		movie.setSongs(songs);
		
		s.save(movie);
		s.save(s1);
		s.save(s2);
		s.save(s3);
		
		tx.commit();
		s.close();
		
	}

}
