package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}



	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployee = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployee);

		return "employees/list-employees";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel){
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int theId, Model theModel){
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";

	}

	@GetMapping("/deleteEmployee")
	public String DeleteEmployee(@RequestParam("employeeId") int theId){
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
}









