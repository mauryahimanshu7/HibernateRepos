package com.zensar.services;

import java.util.List;

import com.zensar.entities.ServiceException;
import com.zensar.entities.User;

public interface UserService 
{
	void addUser(User user) throws ServiceException;
	void updateUser(User user) throws ServiceException;
	void removeUser(User user) throws ServiceException;
	User findUserByUsername(String username) throws ServiceException;
	List<User> findAllUsers() throws ServiceException;
	static boolean validateUser(org.apache.catalina.User clientUser) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}
	boolean validateUser(User user) throws ServiceException;


	
}
