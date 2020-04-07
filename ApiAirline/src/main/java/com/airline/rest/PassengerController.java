package com.airline.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Passenger;
import com.airline.repo.IPassengerRepo;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private IPassengerRepo repository;
	
	@GetMapping(path = "/find")
	public List<Passenger> findId(@RequestParam int id) {
		return (List<Passenger>) repository.findPassenger(id);
	}
	
	@GetMapping(path = "/list")
	public List<Passenger> listar() {
		return (List<Passenger>) repository.findAll();
	}
}
