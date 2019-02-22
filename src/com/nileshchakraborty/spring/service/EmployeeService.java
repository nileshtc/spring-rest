package com.nileshchakraborty.spring.service;

import java.util.List;

import com.nileshchakraborty.spring.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findOne(String id);
	Employee create(Employee employee);
	Employee update(String id, Employee employee);
	void delete(String id);
}
