package com.nileshchakraborty.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nileshchakraborty.spring.entity.Employee;
import com.nileshchakraborty.spring.exception.BadRequestException;
import com.nileshchakraborty.spring.exception.EmployeeNotFoundException;
import com.nileshchakraborty.spring.exception.ResourceNotFoundException;
import com.nileshchakraborty.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findOne(String id) {
		Employee employee= repository.findOne(id);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee with id :"+ id +" not found");
		}
		return employee;
	}

	@Override
	@Transactional
	public Employee create(Employee employee) {
		Employee emp = repository.findByEmail(employee.getEmail());
		if(emp != null) {
			throw new BadRequestException("Cannot Create Employee, already exists: "+ emp);
		}
		
		return repository.create(employee);
	}

	@Override
	@Transactional
	public Employee update(String id, Employee employee) {
		Employee emp = repository.findOne(id);
		if(emp == null) {
			throw new ResourceNotFoundException("Cannot Create Employee, doesnot exists: "+ emp);
		}
		
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Employee emp = repository.findOne(id);
		if(emp == null) {
			throw new ResourceNotFoundException("Cannot Create Employee, doesnot exists: "+ emp);
		}
		
		repository.delete(emp);

	}

}
