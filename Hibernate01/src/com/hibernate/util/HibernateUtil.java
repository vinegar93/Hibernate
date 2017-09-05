package com.hibernate.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private HibernateUtil() {
		
	}
	
	/**
	 * static{}(��static��)�������౻���ص�ʱ��ִ���ҽ��ᱻִ��һ�Σ�һ��������ʼ����̬�����͵��þ�̬����
	 */
	static {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();	
	}

	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
	public static Session getSession() {
		
		return sessionFactory.openSession();
	}
	
	public static void save(Object entity) {
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.save(entity);
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public static void update(Object entity) {
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.update(entity);
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public static void delete(Object entity) {
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			s.delete(entity);
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public static Object get(Class<?> clazz, Serializable id) {
		
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Object obj = s.get(clazz, id);
			return obj;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
