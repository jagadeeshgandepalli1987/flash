package com.zetcode.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.zetcode.bean.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@PersistenceContext
    EntityManager em;
	
	@Override
	public void saveEmployee(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
	}
	
	@Override
	public Employee findEmployeeById(Long empId) {
		Query q = em.createNativeQuery("SELECT EMPID,NAME,ADDRESS FROM Employee b WHERE EMPID = :empId", Employee.class);
		q.setParameter("empId", empId);
		Employee employee = (Employee) q.getSingleResult();
		return employee;
	}

	@Override
	public Employee findEmployeeByName(String name) {
		try {
		Query query = em.createNamedQuery("Employee.findByName");
        query.setParameter("name", name);
        /*System.out.println(query);
        Employee e = (Employee) query.getSingleResult();
        System.out.println(e.getEmpId()+" "+e.getName()+" "+e.getAddress());*/
        return (Employee) query.getSingleResult();
		}catch (NoResultException e) {
			Employee employee = new Employee();
			employee.setEmpId(0l);
			employee.setName("xxxx");
			employee.setAddress("xxxxx");
	        return employee;
		}
	}

	@Override
	public List<Employee> findAll() {
		Query query = em.createNamedQuery("Employee.findAll");
        @SuppressWarnings("unchecked")
		List<Employee> cars = query.getResultList();
		return cars;
	}

}
