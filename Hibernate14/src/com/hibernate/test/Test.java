package com.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Department;
import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;

public class Test {

	@org.junit.Test
	public void test() {
		
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			
			Department depart = new Department();
			depart.setName("depart name");
			
			Employee emp1 = new Employee();
			emp1.setName("emp name1");
			emp1.setDepart(depart);//告诉员工他属于哪个部门
			
			Employee emp2 = new Employee();
			emp2.setName("emp name2");
			emp2.setDepart(depart);//告诉员工他属于哪个部门
			
			Set<Employee> emps = new HashSet<Employee>();
			emps.add(emp1);
			emps.add(emp2);
			
			depart.setEmps(emps);//告诉部门他有哪些员工	
			
			s.save(depart);
			s.save(emp1);
			s.save(emp2);
			
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
