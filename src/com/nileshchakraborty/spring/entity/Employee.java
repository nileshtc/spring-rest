package com.nileshchakraborty.spring.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Employee.findAll", query = "select emp from Employee emp order by emp.email desc"),
		@NamedQuery(name = "Employee.findByEmail", query = "select emp from Employee emp where emp.email=:paramEmail order by emp.email desc")})
public class Employee {
	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private String id;
	private String fname;
	private String lname;
	@Column(unique = true)
	private String email;

	public Employee() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}

}
