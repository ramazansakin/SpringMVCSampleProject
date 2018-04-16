package com.obss.ramazansakin.springpro.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.obss.ramazansakin.springpro.model.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao<Integer, UserRole> implements UserRoleDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> findAllUserRoles() {
		Criteria criteria = createEntityCriteria();
        return (List<UserRole>) criteria.list();
	}

	@Override
	public UserRole findUserRoleById(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (UserRole) criteria.uniqueResult();
	}

}
