package com.joshbarrosweb.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.joshbarrosweb.employee.entities.Employee;
import com.joshbarrosweb.employee.repositories.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping({"/employees", "/", "/list"})
	public ModelAndView listEmployees() {
		ModelAndView mav = new ModelAndView("list-employees");
		List<Employee> list = employeeRepository.findAll();
		mav.addObject("employees", list);
		return mav;
	}

	@GetMapping("/addEmployee")
	public ModelAndView addEmployee() {
		ModelAndView mav = new ModelAndView("add-employee");
		Employee newEmployee = new Employee();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/editEmployee")
	public ModelAndView editEmployee(@RequestParam Long employeeId) {
		ModelAndView mav = new ModelAndView("add-employee");
		Employee employee = employeeRepository.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return "redirect:/list";
	}
}
