package com.zetcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetcode.bean.Employee;
import com.zetcode.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	//--------------------------------Home page----------------------------------------------
		@RequestMapping(value = "/home")
		public String home() {
			
			return "home";
		}
			
		
		//--------------------------------Registration page----------------------------------------------
		@RequestMapping(value = "/register", method=RequestMethod.GET)
		//@GetMapping("/register")
	    public String greetingForm(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "register";
	    }

		@RequestMapping(value = "/register", method=RequestMethod.POST)
	    //@PostMapping("/register")
	    public String greetingSubmit(@ModelAttribute Employee employee) {
	    	System.out.println(employee.getEmpId()+" "+employee.getName()+" "+employee.getAddress());
	        return "success";
	    }
		
		//--------------------------------Login page----------------------------------------------
		@RequestMapping(value = "/index")
		public String index() {
			System.out.println("run method running");
			Employee e=service.findEmployeeByName("Volkswagen");
			System.out.println(e.getEmpId()+ " " + e.getName()+" "+e.getAddress() );
			System.out.println("Employee Inserted!!!");
			return "index";
		}
	
}
