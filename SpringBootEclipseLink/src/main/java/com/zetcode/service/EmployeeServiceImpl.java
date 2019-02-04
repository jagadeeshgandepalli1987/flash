
package com.zetcode.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.zetcode.bean.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public void saveEmployee(Employee employee) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (!ObjectUtils.isEmpty(employee) && !em.contains(employee)) {
			em.persist(employee);
		}
		System.out.println("is active :::" + tx.isActive());
		em.getTransaction().commit();
	}

	@Override
	public void updateEmployee(Employee employee) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if (!ObjectUtils.isEmpty(employee) && !em.contains(employee)) {
			em.merge(employee);
		}

	}

	@Override
	public Employee findEmployeeById(Long empId) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNativeQuery("SELECT EMPID,NAME,ADDRESS FROM Employee b WHERE EMPID = :empId",
				Employee.class);
		q.setParameter("empId", empId);
		Employee employee = (Employee) q.getSingleResult();
		return employee;
	}

	@Override
	public Employee findEmployeeByName(String name) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery("Employee.findByName");
			query.setParameter("name", name);
			/*
			 * System.out.println(query); Employee e = (Employee) query.getSingleResult();
			 * System.out.println(e.getEmpId()+" "+e.getName()+" "+e.getAddress());
			 */
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			Employee employee = new Employee();
			employee.setEmpId(0l);
			employee.setName("xxxx");
			employee.setAddress("xxxxx");
			return employee;
		}
	}

	@Override
	public List<Employee> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Employee.findAll");
		@SuppressWarnings("unchecked")
		List<Employee> cars = query.getResultList();
		return cars;
	}

	@Override
	public List<Object> findAllList() {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder criteriaBuilderObj = em.getCriteriaBuilder();

		// Making The Query Object From The 'CriteriaBuilder' Instance
		CriteriaQuery<Object> queryObj = criteriaBuilderObj.createQuery();
		Root<Employee> from = queryObj.from(Employee.class);

		// Step #1 - Displaying All Records
		System.out.println("\n! Display All Records For The 'Employee' Table !\n");
		CriteriaQuery<Object> selectQuery = queryObj.select(from);
		TypedQuery<Object> typedQuery = em.createQuery(selectQuery);
		List<Object> employeeList = typedQuery.getResultList();
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public List<Object> findAllASC() {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder criteriaBuilderObj = em.getCriteriaBuilder();
		// Making The Query Object From The 'CriteriaBuilder' Instance
		CriteriaQuery<Object> queryObj = criteriaBuilderObj.createQuery();
		Root<Employee> from = queryObj.from(Employee.class);
		// Step #2 - Displaying All Records In An Ordered Fashion
        System.out.println("\n! Displaying All Records For The 'Employee' Table In An Asc. Order !\n");
        CriteriaQuery<Object> ascSelectQuery = queryObj.select(from);
        ascSelectQuery.orderBy(criteriaBuilderObj.asc(from.get("name")));
        TypedQuery<Object> ascTypedQuery = em.createQuery(ascSelectQuery);
        List<Object> ascEmployeeList = ascTypedQuery.getResultList();
		return ascEmployeeList;
	}
}
