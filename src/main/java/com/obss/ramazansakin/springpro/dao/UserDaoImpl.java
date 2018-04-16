package com.obss.ramazansakin.springpro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.obss.ramazansakin.springpro.model.User;
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
	@Override
	public User findById(int id) {
		return getByKey(id);
	}
	
    public void saveUser(User user) {
        persist(user);
    }
 
    public void deleteUserById(int id) {
        Query query = getSession().createSQLQuery("delete from Employee where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
 
    public User findUserById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (User) criteria.uniqueResult();
    }


}

