package com.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Student;
import com.hibernate.domain.Teacher;
import com.hibernate.util.HibernateUtil;

public class Test {

	@org.junit.Test
	public void test() {
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			
			Set<Student> ss = new HashSet<Student>();
			Set<Teacher> ts = new HashSet<Teacher>();
			
			Teacher t1 = new Teacher();
			t1.setName("t1");
			ts.add(t1);
			
			Teacher t2 = new Teacher();
			t2.setName("t2");
			ts.add(t2);
			
			Student s1 = new Student();
			s1.setName("s1");
			ss.add(s1);
			
			Student s2 = new Student();
			s2.setName("s2");
			ss.add(s2);
			
			t1.setStudents(ss);//������ʦ������Щѧ��
			t2.setStudents(ss);//������ʦ������Щѧ��
			
			/**
			 * ���������д��벻��ͬʱʹ��
			 * s1.setTeachers(ts);//����ѧ��������ʦ��˭
			 * s2.setTeachers(ts);//����ѧ��������ʦ��˭
			 */

			s.save(t1);		
			s.save(t2);		
			s.save(s1);		
			s.save(s2);		
			
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
