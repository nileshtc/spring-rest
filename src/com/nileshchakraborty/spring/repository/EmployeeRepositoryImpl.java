package com.nileshchakraborty.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nileshchakraborty.spring.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> que = entityManager.createNamedQuery("Employee.findAll",Employee.class);
		return que.getResultList();
		
	}

	@Override
	public Employee findOne(String id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee findByEmail(String email) {
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByEmail",Employee.class);
		query.setParameter("paramEmail", email);
		List<Employee> employees = query.getResultList();
		if(employees != null && employees.size() == 1) {
			return employees.get(0);
		}
		return null;
	}

	@Override
	public Employee create(Employee emp) {
		entityManager.persist(emp);
		return emp;
	}

	@Override
	public Employee update(Employee emp) {
		//System.out.println(emp);
		entityManager.merge(emp);
		return emp;
	}

	@Override
	public void delete(Employee emp) {
		entityManager.remove(emp);
	}

}
