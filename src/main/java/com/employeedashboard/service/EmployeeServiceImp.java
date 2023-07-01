package com.employeedashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedashboard.models.Employee;
import com.employeedashboard.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService
{
	@Autowired
	EmployeeRepository repo;

	public List<Employee> getEmployeeList()
	{
	    return repo.getRecord();	
		
	}

	@Override
	public void addEmployee(Employee employee) {
		repo.addrecord(employee);
		
	}

	@Override
	public void deleteEmployee(int eid) 
	{
		repo.deleteRecord(repo.searchEmployee(eid));
		
	}

	@Override
	public Employee searchEmployee(int eid) {
		
		return repo.searchEmployee(eid);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee oldemp=repo.searchEmployee(employee.getEid());
		repo.updateRecord(oldemp,employee);
		
	}

}
