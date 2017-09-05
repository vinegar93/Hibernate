package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.domain.User;
import com.hibernate.util.HibernateUtil;

public class UserDao {

	public User getUser(int id) {
		
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			/**
			 * 懒加载
			 */
			User user = (User)s.load(User.class, id);
			/**
			 * 初始化代理对象
			 * 例如：Hibernate.initialize(user)或user.getName()
			 */
			user.getName();
			return user;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public User queryUserByName(String name) {
		
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from User where name=:name";
			Query query = s.createQuery(hql);
			query.setString("name", name);		
			User user = (User)query.uniqueResult();
			return user;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public List<User> queryAllUser() {
		
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			String hql = "from User";
			Query query = s.createQuery(hql);		
			List<User> users = query.list();
			return users;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public User criUserByName(String name) {
		
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(User.class);
			c.add(Restrictions.eq("name", name));
			User user = (User)c.uniqueResult();
			return user;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public List<User> criAllUser() {
		
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(User.class);		
			List<User> users = c.list();		
			return users;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
