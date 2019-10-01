package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author HIMANSHU MAURYA.
 * @version 2.0
 * @creation_date 21st September 5:23 PM
 * @modification_date 28st September 5:23 PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description Java Bean Class used to represent database entity.
 * It is also used as value object.
 * It is used in all layers.
 */
@Entity
@Table(name = "user_login")
public class User 
	{
		public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		@Id
		private String username;
		private String password;
		
		@Override
		public String toString() 
		{
			return "User [username=" + username + ", password=" + password + "]";
		}
		
		
	
	
	}
