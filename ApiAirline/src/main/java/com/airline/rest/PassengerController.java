package com.airline.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Passenger;
import com.airline.repo.IPassengerListRepo;
import com.airline.repo.IPassengerRepo;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private IPassengerRepo repository;
	@Autowired
	private IPassengerListRepo listRepo;
	
	@GetMapping(path = "/find")
	public List<Passenger> findId(@RequestParam int id) {
		return (List<Passenger>) repository.findPassenger(id);
	}
	
	@GetMapping(path = "/flight-passenger")
	public List<Passenger> flightPassenger(@RequestParam int numflight) {
		return (List<Passenger>) repository.listPassenger(numflight);
	}
	
	@GetMapping(path = "/list")
	public List<Passenger> listar() {
		return (List<Passenger>) repository.findAll();
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewPassenger(@RequestParam int id, @RequestParam String namep,
			@RequestParam String birthdate, @RequestParam String email, @RequestParam int telephone,
			@RequestParam int numflight) {
		repository.addPassenger(id, namep, birthdate, email, telephone);
		listRepo.addPassenger(numflight, id);
		return "Se ha creado el pasajero exitosamente";
	}
}
