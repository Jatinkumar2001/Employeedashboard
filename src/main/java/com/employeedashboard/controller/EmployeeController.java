package com.employeedashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeedashboard.models.Employee;
import com.employeedashboard.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@RequestMapping("/")
	public String getDashBoardView(Model model)
	{
		List<Employee> lst=service.getEmployeeList();
		model.addAttribute("elist", lst);
		return "Employee-Dashboard";
	}
	@RequestMapping("add")
	public String getAddView()
	{
		return "add";
	}
	@RequestMapping("addEmployee")
	public String addEmployee(Employee employee)
	{
		service.addEmployee(employee);
		return "redirect:/";
	}
	
	
	@RequestMapping("delete")
	public String deleteEmployee(int eid) {
		System.out.println("called");
        service.deleteEmployee(eid);

		return "redirect:/";
	}
	@RequestMapping("edit")
	public String editEmployee(int eid,Model model)
	{

		model.addAttribute("employee",service.searchEmployee(eid));
		return "edit";
	}

	@RequestMapping("editEmployee")
	public String saveEditedEmployee(Employee employee)
	{
		service.updateEmployee(employee);

		return "redirect:/";
	}
}
