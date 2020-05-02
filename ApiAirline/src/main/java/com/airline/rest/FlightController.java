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

import com.airline.model.Flights;
import com.airline.model.Passenger;
import com.airline.repo.IAirPlaneRepo;
import com.airline.repo.IFlightRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private IFlightRepo repository;
	@Autowired
	private IAirPlaneRepo airplanerepo;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewFlight(@RequestBody Flights flights) {

		if(airplanerepo.existsById(flights.getPlanecode())) {
			repository.addFlight(flights.getPlanecode(), flights.getDateflight(), flights.getOrigin(), flights.getDestination());
			return "Se ha creado el vuelo exitosamente";
		}else {
			return "El avión que se intenta vincular a este vuelo no existe.";
		}
	}
	
	@PostMapping(path = "/update")
	public void updateFlight(@RequestBody Flights flights) {
		if(repository.existsById(flights.getNumVuelo()) && airplanerepo.existsById(flights.getPlanecode())) {
			repository.updateFlight(flights.getNumVuelo(), flights.getPlanecode(), flights.getDateflight(), flights.getOrigin(), flights.getDestination());
			
		}
	}
	
	//Función para buscar un pasajero por identificación
	@GetMapping(path = "/find")
	public List<Flights> findId(@RequestParam int id) {
		return (List<Flights>) repository.findFlight(id);
	}
	
	@GetMapping(path = "/list")
	public List<Flights> listar() {
		return (List<Flights>) repository.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
}
