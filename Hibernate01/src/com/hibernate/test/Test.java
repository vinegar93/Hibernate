package com.hibernate.test;

import java.util.List;

import com.hibernate.dao.UserDao;
import com.hibernate.domain.User;
import com.hibernate.util.HibernateUtil;

public class Test {

	@org.junit.Test
	public void save() {
		
		User user = new User();
		user.setName("Tom");
		user.setPassword("123456");
		HibernateUtil.save(user);
	}
	
	@org.junit.Test
	public void update() {
		
		User user = new User();
		user.setId(1);
		user.setName("Tom");
		user.setPassword("456789");
		HibernateUtil.update(user);
	}
	
	@org.junit.Test
	public void delete() {
		
		User user = new User();
		user.setId(1);
		HibernateUtil.delete(user);
	}
	
	@org.junit.Test
	public void get() {
		
		User user = (User)HibernateUtil.get(User.class, 1);
		System.out.println(user.toString());
	}
	
	@org.junit.Test
	public void load() {
		
		UserDao userDao = new UserDao();
		User user = userDao.getUser(1);
		System.out.println(user.toString());
	}
	
	@org.junit.Test
	public void queryUserByName() {
		
		UserDao userDao = new UserDao();
		User user = userDao.queryUserByName("Tom");
		System.out.println(user.toString());
	}
	
	@org.junit.Test
	public void queryAllUser() {
		
		UserDao userDao = new UserDao();
		List<User> users = userDao.queryAllUser();
		System.out.println(users.toString());
	}
	
	@org.junit.Test
	public void criUserByName() {
		
		UserDao userDao = new UserDao();
		User user = userDao.criUserByName("Jerry");
		System.out.println(user.toString());
	}
	
	@org.junit.Test
	public void criAllUser() {
		
		UserDao userDao = new UserDao();
		List<User> users = userDao.criAllUser();
		System.out.println(users.toString());
	}
}
