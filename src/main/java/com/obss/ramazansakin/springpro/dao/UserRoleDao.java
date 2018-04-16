package com.obss.ramazansakin.springpro.dao;

import java.util.List;

import com.obss.ramazansakin.springpro.model.UserRole;

public interface UserRoleDao {
	
	public List<UserRole> findAllUserRoles();
 
    public UserRole findUserRoleById(int id);

}
