package com.employeedashboard.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employeedashboard.models.Employee;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository
{

	Session ses;
	Transaction t;
	@Autowired
	public EmployeeRepositoryImp(SessionFactory factory)
	{
		ses=factory.openSession();
		t=ses.getTransaction();
	}
	public List<Employee> getRecord() 
	{
	   Query<Employee> lst=ses.createQuery("from Employee");
	   return lst.list();
		
	}
	@Override
	public void addrecord(Employee employee) {
		t.begin();
		ses.save(employee);
		t.commit();
		
	}
	
	public void deleteRecord(Employee employee) {
		t.begin();
		ses.delete(employee);
		t.commit();
	}
	@Override
	public Employee searchEmployee(int eid) {
		
		return ses.get(Employee.class, eid);
	}
	@Override
	public void updateRecord(Employee oldemp, Employee employee) {
		oldemp.setFirstName(employee.getFirstName());
		oldemp.setLastName(employee.getLastName());
		oldemp.setPhoneNo(employee.getPhoneNo());
		oldemp.setSalary(employee.getSalary());
		oldemp.setDepartment(employee.getDepartment());
		
	}

}
