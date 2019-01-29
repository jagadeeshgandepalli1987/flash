package com.zetcode.service;

import com.zetcode.bean.Car;
import java.util.List;

public interface CarsService {

    public void saveCar(Car car);

    public Car findCarByName(String name);

    public List<Car> findAll();
}
