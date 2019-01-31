package com.zetcode.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByName", 
            query = "SELECT e FROM Employee e WHERE e.name = :name")
})
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long empId;
    private String name;
    private String address;
    
    public Employee() {
		System.out.println("Employee 0-param constructor");
	}
    
	public Employee(Long empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + "]";
	}
	

}
