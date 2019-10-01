package com.zensar.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.User;

/**
 * @author Himanshu MAurya
 * @version 2.0
 * @creation_date 21st sep 2019 5.35PM
 * @modification_date 28rd sep 2019 10.10AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description:It is Data Access Object Interface implementor class. It is used
 *                 in Persistance layer of application.
 */
public class UserDaoImpl implements UserDao {
	
	private Session session;
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
		Configuration con = new Configuration().configure();
		SessionFactory s = con.buildSessionFactory();
		session = s.openSession();
		
	}

	@Override
	public void insert(User user) {
		Transaction tx= session.beginTransaction();
		session.save(user);
		tx.commit();
		
	}

	@Override
	public void update(User user) {
		Transaction tx= session.beginTransaction();
		session.update(user);
		tx.commit();
		
	}

	@Override
	public void delete(User user) {
		Transaction tx= session.beginTransaction();
		session.delete(user);
		tx.commit();
		
	}

	@Override
	public User getByUserName(String username) {
		// TODO Auto-generated method stub
		return session.get(User.class, username);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Query q = session.createQuery("from User");
		return q.getResultList();
	}

	

}
