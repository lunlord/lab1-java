package com.example.demo.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import  com.example.demo.service.CarService;
import 	com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;
	
	public CarServiceImpl(com.example.demo.repository.CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Car getCarId(Long id) {
		return carRepository.findById(id).get();
	}

	@Override
	public Car updateCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}
	
	
	
}
