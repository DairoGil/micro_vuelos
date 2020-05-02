package com.airline.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Passenger;
import com.airline.model.Passengerlist;
import com.airline.repo.IPassengerListRepo;
import com.airline.repo.IPassengerRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private IPassengerRepo repository;
	@Autowired
	private IPassengerListRepo listRepo;
	
	//Función para buscar un pasajero por identificación
	@GetMapping(path = "/find")
	public List<Passenger> findId(@RequestParam int id) {
		return (List<Passenger>) repository.findPassenger(id);
	}
	
	//Función para listar los pasajeros de un vuelo
	@GetMapping(path = "/flight-passenger")
	public List<Passenger> flightPassenger(@RequestParam int numflight) {
		return (List<Passenger>) repository.listPassenger(numflight);
	}
	
	//Función para listar todos los registros de los pasajeros
	@GetMapping(path = "/list")
	public List<Passenger> listar() {
		return (List<Passenger>) repository.findAll();
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewPassenger(@RequestBody Passenger passenger) {
		repository.addPassenger(passenger.getId(), passenger.getName(), passenger.getBirthdate(), passenger.getEmail(), passenger.getTelephone());
		return "Se ha creado el pasajero exitosamente";
	}
	
	@PostMapping(path = "/addList")
	public void addList(@RequestBody Passengerlist passengerlist) {
		System.out.println(passengerlist);
		System.out.println(passengerlist.getNumFlight()+" "+passengerlist.getIdPassenger());
		listRepo.addPassenger(passengerlist.getNumFlight(), passengerlist.getIdPassenger());
	}
	
	
	@PostMapping(path = "/update")
	public @ResponseBody String updatePassenger(@RequestBody Passenger passenger) {
		if(repository.existsById(passenger.getId())) {
			repository.updatePassenger(passenger.getId(),  passenger.getTelephone(), passenger.getName(), passenger.getBirthdate(), passenger.getEmail());
			return "Se ha actualizado el pasajero exitosamente.";
		}else {	
			return "El registro a actualizar no existe";
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
}
