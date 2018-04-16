package com.obss.ramazansakin.springpro.dao;

import java.util.List;

import com.obss.ramazansakin.springpro.model.User;

public interface UserDao {
	
	public User findById(int id);
	 
    void saveUser(User user);
     
    void deleteUserById(int id);
     
    List<User> findAllUsers();
 
    User findUserById(int id);
	
}
