package com.sarva.cacheservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

	private CacheService cacheService;

	public CacheController(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@GetMapping("/hi/{name}")
	public String sayHi(@PathVariable String name) {
		return "Hi, " + name.toUpperCase();
	}

	@GetMapping("/cars/{make}")
	public Car getCarByMake(@PathVariable String make) {
		return cacheService.getCarByMake(make);
	}

	@GetMapping("/cars")
	public List<Car> getCars() {
		return cacheService.getAllCars();
	}

}
