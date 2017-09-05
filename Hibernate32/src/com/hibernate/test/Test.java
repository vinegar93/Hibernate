package com.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Department;
import com.hibernate.domain.Employee;
import com.hibernate.domain.Sales;
import com.hibernate.domain.Skiller;
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
			emp1.setDepart(depart);
			
			Skiller emp2 = new Skiller();
			emp2.setName("emp name2");
			emp2.setSkill("skill");
			emp2.setDepart(depart);
			
			Sales emp3 = new Sales();
			emp3.setName("emp name3");
			emp3.setSell(100);
			emp3.setDepart(depart);
			
			Set<Employee> emps = new HashSet<Employee>();
			emps.add(emp1);
			emps.add(emp2);
			emps.add(emp3);
			
			depart.setEmps(emps);
			
			s.save(depart);
			
			tx.commit();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
}
