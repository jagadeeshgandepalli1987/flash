package com.zetcode.service;

import java.util.List;

import com.zetcode.bean.Car;
import com.zetcode.bean.Employee;

public interface EmployeeService {
	
    public void saveEmployee(Employee employee);

    public Employee findEmployeeByName(String name);

    public List<Employee> findAll();
	

}
