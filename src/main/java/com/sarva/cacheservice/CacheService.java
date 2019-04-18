package com.sarva.cacheservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CacheService {

	@Autowired
	private RestTemplate restTemplate;

	public CacheService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Cacheable(value = "cars-by-make", key = "#make", cacheManager = "redisCacheManager")
	public Car getCarByMake(String make) {
		return restTemplate.getForObject("http://localhost:8081/cars/" + make, Car.class);
	}

	@Cacheable(value = "cars-all", cacheManager = "redisCacheManager")
	public List<Car> getAllCars() {
		ParameterizedTypeReference<List<Car>> carsResponse = new ParameterizedTypeReference<List<Car>>() {
		};

		return restTemplate.exchange("http://localhost:8081/cars", HttpMethod.GET, null, carsResponse).getBody();
	}
	
}
