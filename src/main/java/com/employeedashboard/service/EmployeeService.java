package com.employeedashboard.service;

import java.util.List;

import com.employeedashboard.models.Employee;

public interface EmployeeService {

	List<Employee> getEmployeeList();

	void addEmployee(Employee employee);

	void deleteEmployee(int eid);

    Employee searchEmployee(int eid);

	void updateEmployee(Employee employee);

}
