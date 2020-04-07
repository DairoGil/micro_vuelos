package com.airline.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Flights;
import com.airline.repo.IFlightRepo;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private IFlightRepo repository;

	@GetMapping(path = "/list")
	public List<Flights> listar() {
		return (List<Flights>) repository.findAll();
	}
}
