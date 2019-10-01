package com.zensar.services;

import java.sql.SQLException;
import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.ServiceException;
import com.zensar.entities.User;

public class UserServiceImpl implements UserService{

	private UserDao userdao;
	
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		try {
			userdao.insert(user);
		} catch (SQLException e) {
			
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void updateUser(User user) throws ServiceException {
	     try {
			userdao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	     
		
	}

	@Override
	public void removeUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			userdao.delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public User findUserByUsername(String username) throws ServiceException {
		// TODO Auto-generated method stub
		User user;
		try {
			user = userdao.getByUserName(username);
			return user;
		} catch (SQLException e) {
		
			throw new ServiceException(e.getMessage());
			
		}
		
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return userdao.getAll();
		} catch (SQLException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
		User dbUser=  findUserByUsername(user.getUsername());
		
		if(dbUser!=null && dbUser.getPassword().equals(user.getPassword()))
			return true;
		else
		    return false;
	}
	
	

}

