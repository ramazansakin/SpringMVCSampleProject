package com.obss.ramazansakin.springpro.service;

import java.util.List;

import com.obss.ramazansakin.springpro.model.UserRole;

public interface UserRoleService {
	
	List<UserRole> findAllUserRoles(); 
    
    UserRole findUserRoleById(int id);

}
