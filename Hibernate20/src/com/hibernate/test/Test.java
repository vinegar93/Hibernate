package com.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.IdCard;
import com.hibernate.domain.Person;
import com.hibernate.util.HibernateUtil;

public class Test {

	@org.junit.Test
	public void test() {
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			
			IdCard idCard = new IdCard();
			idCard.setUsefulLife(new Date());
			
			Person p = new Person();
			p.setName("p1");
			p.setIdCard(idCard);
			
			idCard.setPerson(p);

			s.save(p);
			s.save(idCard);			
			
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
