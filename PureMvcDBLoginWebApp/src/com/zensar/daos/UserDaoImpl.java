package com.zensar.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zensar.entities.User;

/**
 * @author Chaithrodaya B.S.
 * @version 1.0
 * @creation_date 21st sep 2019 5.35PM
 * @modification_date 23rd sep 2019 10.10AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description:It is Data Access Object Interface implementor class. It is used
 *                 in Persistance layer of application.
 */
public class UserDaoImpl implements UserDao {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(User user) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into user_login values(?,?) ";
		PreparedStatement pst = connection.prepareCall(sql);
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		int insertCount = pst.executeUpdate();
		if (insertCount > 0)
			System.out.println("new user is inserted");
		else
			System.out.println("new user cannot is inserted");

	}

	@Override
	public void update(User user) throws SQLException {
		String sql="update user_login set password=? where username=?";
		PreparedStatement pastmt = connection.prepareStatement(sql);
		pastmt.setString(1,user.getPassword());
		pastmt.setString(2, user.getUsername());
		int updateCount = pastmt.executeUpdate();
		if(updateCount>0)
		{
			System.out.println("User record is updated Successfully");
		}
		else
		{
			System.out.println("S0rry!!! record not updated");
		}
	}

	@Override
	public void delete(User user) throws SQLException {
		String sql="delete from user_login  where username=?";
		PreparedStatement pastmt = connection.prepareStatement(sql);
		pastmt.setString(1, user.getUsername());
		int deleteCount = pastmt.executeUpdate();
		if(deleteCount>0)
		{
			System.out.println("User record is deleted Successfully");
		}
		else
		{
			System.out.println("S0rry!!! record not deleted");
		}


	}

	@Override
	public User getByUserName(String username) throws SQLException{

		String sql = "select username, password from user_login where username=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;

		} else
			return null;
	}

	@Override
	public List<User> getAll() throws SQLException{
	
		String sql="select * from user_login";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<User> users=new ArrayList<User>();
		if(rs.next())
		{
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			users.add(user);
		}
		
		return users;
	}

}
