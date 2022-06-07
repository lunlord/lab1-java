package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Car;

public interface CarService {
	List<Car> getAllCars();
	
	Car saveCar(Car car);
	
	Car getCarId (Long id);
	
	Car updateCar(Car car); 
	
	void deleteCar(Long id);
}
