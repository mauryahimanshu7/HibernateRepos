package com.zensar.daos;

import java.util.List;

import com.zensar.entities.User;

/**
 * @author Himanshu MAurya
 * @version 2.0
 * @creation_date 21st sep 2019 5.29PM
 * @modification_date 28st sep 2019 5.29PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description:It is Data Access Object Interface. It is used in persistance
 *                 layer of application.
 */
public interface UserDao {

	void insert(User user);

	void update(User user);

	void delete(User user);

	User getByUserName(String username);

	List<User> getAll();

}
