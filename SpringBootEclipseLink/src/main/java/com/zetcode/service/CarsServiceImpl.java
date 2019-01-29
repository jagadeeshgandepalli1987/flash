package com.zetcode.service;

import com.zetcode.bean.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class CarsServiceImpl implements CarsService {

    @PersistenceContext
    EntityManager em;

    @Override
    public void saveCar(Car car) {

        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
    }

    @Override
    public Car findCarByName(String name) {
    	try {
        Query query = em.createNamedQuery("Car.findByName");
        query.setParameter("name", name);
        Car car = (Car) query.getSingleResult();
        return car;
    	}catch (NoResultException e) {
    		System.out.println("No Result Found.");
			return null;
		}
    }

    @Override
    public List<Car> findAll() {

        Query query = em.createNamedQuery("Car.findAll");
        
        @SuppressWarnings("unchecked")
		List<Car> cars = query.getResultList();

        return cars;
    }
}
