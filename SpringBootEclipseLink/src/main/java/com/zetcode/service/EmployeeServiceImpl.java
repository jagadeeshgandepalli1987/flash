package com.zetcode.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public Employee findEmployeeByName(String name) {
		Query query = em.createNamedQuery("Employee.findByName");
        query.setParameter("name", name);
        return (Employee) query.getSingleResult();
	}

	@Override
	public List<Employee> findAll() {
		Query query = em.createNamedQuery("Employee.findAll");
        @SuppressWarnings("unchecked")
		List<Employee> cars = query.getResultList();
		return cars;
	}

}
