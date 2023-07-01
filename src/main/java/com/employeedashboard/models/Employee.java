package com.employeedashboard.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
	@Id
	@GeneratedValue(generator = "emp_seq")
	@SequenceGenerator(name = "emp_seq" ,initialValue = 101,allocationSize = 1)
	private int eid;
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", department=" + department + ", salary=" + salary + "]";
	}
	private String firstName;
	private String lastName;
	private int phoneNo;
	private String department;
	private int salary;
	public Employee() {}
	public Employee(String firstName, String lastName, int phoneNo, String department, int salary) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.department = department;
		this.salary = salary;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	

}
