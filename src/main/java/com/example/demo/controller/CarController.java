package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;

@Controller
public class CarController {
	
	private CarService carService;

	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/cars")
	public String listCars(Model model) {
		model.addAttribute("cars", carService.getAllCars());
		return "cars";	
	} 
	
	@GetMapping("/cars/new")
	public String CreateCar(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		return "create_new_car";
	}
	
	@PostMapping("/cars")
	public String SaveCar(@ModelAttribute("car") Car car) {
		 carService.saveCar(car);
		 return "redirect:/cars";
	}
	
	@GetMapping("/cars/update/{id}")
	public String UpdateCarForm(@PathVariable Long id, Model model) {
		model.addAttribute("car", carService.getCarId(id));
		return "update_car";
	}
	
	@PostMapping("/cars/{id}")
	public String UpdateCar(@PathVariable Long id, 
			@ModelAttribute("car") Car car, Model model) {
		Car existingCar = carService.getCarId(id);
		existingCar.setId(id);
		existingCar.setName(car.getName());
		existingCar.setManufacturer(car.getManufacturer());
		existingCar.setCost(car.getCost());
		
		carService.updateCar(existingCar);
		return "redirect:/cars";
	}
	
	@GetMapping("/cars/{id}")
	public String DeleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
		return "redirect:/cars";
	}
}
