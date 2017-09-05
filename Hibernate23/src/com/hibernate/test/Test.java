package com.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Name;
import com.hibernate.domain.User;
import com.hibernate.util.HibernateUtil;

public class Test {

	@org.junit.Test
	public void test() {
	
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			
			Name name = new Name();
			name.setFirstName("firstName");
			name.setLastName("lastName");
			
			User user = new User();
			user.setName(name);
			user.setBirthday(new Date());

			s.save(user);		
			
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
