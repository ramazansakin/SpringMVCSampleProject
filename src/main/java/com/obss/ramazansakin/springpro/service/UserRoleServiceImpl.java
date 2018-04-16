package com.obss.ramazansakin.springpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obss.ramazansakin.springpro.dao.UserRoleDao;
import com.obss.ramazansakin.springpro.model.UserRole;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
    private UserRoleDao dao;
	
	@Override
	public List<UserRole> findAllUserRoles() {
		return dao.findAllUserRoles();
	}

	@Override
	public UserRole findUserRoleById(int id) {
		return dao.findUserRoleById(id);
	}

}
