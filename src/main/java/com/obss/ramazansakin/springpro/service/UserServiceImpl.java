package com.obss.ramazansakin.springpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obss.ramazansakin.springpro.dao.UserDao;
import com.obss.ramazansakin.springpro.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
    private UserDao dao;
	
	@Override
	public User findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveUser(User user) {
		dao.saveUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setName(user.getName());
            entity.setBirthday(user.getBirthday());
            entity.setSex(user.getSex());
            entity.setEnabled(user.getEnabled());
            
        }
	}

	@Override
	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public User findUserById(int id) {
		return dao.findUserById(id);
	}

	@Override
	public boolean isUserIdUnique(Integer id) {
		User user = findUserById(id);
        return ( user == null || ((id != null) ));
	}
	
}
