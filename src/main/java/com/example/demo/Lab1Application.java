package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}
	
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		Car car1 = new Car("Lada", "Vaz", 50000);
//		carRepository.save(car1);
		
	}

}
