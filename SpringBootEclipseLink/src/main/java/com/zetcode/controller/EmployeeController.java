package com.zetcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zetcode.bean.Employee;
import com.zetcode.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	//--------------------------------Home page----------------------------------------------
		@RequestMapping(value = "/home",method=RequestMethod.GET)
		public String home(Model model) {
			List<Employee> list=service.findAll();
			
			for (Employee employee : list) {
				System.out.println(employee.toString());
			}
			model.addAttribute("emplist", list);
			
			System.out.println("criteria API:::");
			List<Object> list1=service.findAllList();
			for (Object object : list1) {
				Employee employee= (Employee)object;
				System.out.println(employee.toString());
			}
			
			System.out.println("Ascending Order :::");
			List<Object> ascEmployeeList=service.findAllASC();
			if(ascEmployeeList != null && ascEmployeeList.size() > 0) {
	            for(Object obj : ascEmployeeList) {
	                Employee emp = (Employee)obj;
	                System.out.println(emp.toString());
	            }
	        } else {
	            System.out.println("! ALERT - No Employees Are Present In The 'Employee' Table !");
	        }
			
			
			
			
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
			service.saveEmployee(employee);
	    	System.out.println(employee.getEmpId()+" "+employee.getName()+" "+employee.getAddress());
	        return "success";
	    }
		//--------------------------------Edit Record----------------------------------------------
		@RequestMapping(value = "/edit", method=RequestMethod.GET)
		//@GetMapping("/register")
	    public String editEmployeeForm(@RequestParam Long id,Model model) {
			Employee employee = service.findEmployeeById(id);
	        model.addAttribute("employeeEdit", employee);
	        return "update";
	    }

		@RequestMapping(value = "/update/{id}", method=RequestMethod.POST)
	    //@PostMapping("/register")
	    public String updateEmployeeForm(@RequestParam Long id,@ModelAttribute Employee employee) {
			service.saveEmployee(employee);
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
