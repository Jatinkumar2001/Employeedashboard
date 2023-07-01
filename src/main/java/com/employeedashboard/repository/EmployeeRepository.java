package com.employeedashboard.repository;

import java.util.List;

import com.employeedashboard.models.Employee;

public interface EmployeeRepository {

	List<Employee> getRecord();

	void addrecord(Employee employee);

	void deleteRecord(Employee employee);

	Employee searchEmployee(int eid);

	void updateRecord(Employee oldemp, Employee employee);



}
