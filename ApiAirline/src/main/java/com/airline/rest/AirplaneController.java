package com.airline.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Airplanes;
import com.airline.repo.IAirPlaneRepo;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {

	@Autowired
	private IAirPlaneRepo repository;

	@GetMapping(path = "/list")
	public List<Airplanes> listar() {
		return (List<Airplanes>) repository.findAll();
	}

	@PostMapping(path = "/add")
	public void addNewAirplane(@RequestParam String description, @RequestParam int capacity) {
		Airplanes airplane = new Airplanes();
		airplane.setDescription(description);
		airplane.setCapacity(capacity);
		repository.save(airplane);
	}

	@PutMapping(path = "/update")
	public void update(@RequestParam int id, @RequestParam String description, @RequestParam int capacity) {
		Airplanes airplane = new Airplanes();
		airplane.setPlanecode(id);
		airplane.setDescription(description);
		airplane.setCapacity(capacity);
		if (airplane != null) {
			repository.save(airplane);
		}
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

}
