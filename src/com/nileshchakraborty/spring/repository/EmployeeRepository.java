package com.nileshchakraborty.spring.repository;

import java.util.List;

import com.nileshchakraborty.spring.entity.Employee;

public interface EmployeeRepository {
	List<Employee> findAll();

	Employee findOne(String id);
	
	Employee findByEmail(String email);
	
	Employee create(Employee emp);
	
	Employee update(Employee emp);
	
	void delete(Employee emp);
} 
