package com.obss.ramazansakin.springpro.service;

import java.util.List;

import com.obss.ramazansakin.springpro.model.User;
 
public interface UserService {
 
    User findById(int id);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(int id);
 
    List<User> findAllUsers(); 
     
    User findUserById(int id);
 
    boolean isUserIdUnique(Integer id);
     
}
