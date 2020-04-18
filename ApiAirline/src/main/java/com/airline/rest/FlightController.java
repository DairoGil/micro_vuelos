package com.airline.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Flights;
import com.airline.repo.IAirPlaneRepo;
import com.airline.repo.IFlightRepo;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private IFlightRepo repository;
	@Autowired
	private IAirPlaneRepo airplanerepo;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewFlight(@RequestParam int planecode, @RequestParam String dateFlight,
			@RequestParam String origin, @RequestParam String destination) {
		if(airplanerepo.existsById(planecode)) {
			repository.addFlight(planecode, dateFlight, origin, destination);
			return "Se ha creado el vuelo exitosamente";
		}else {
			return "El avión que se intenta vincular a este vuelo no existe.";
		}
	}
	
	@PostMapping(path = "/update")
	public @ResponseBody String updateFlight(@RequestParam int numflight, @RequestParam int planecode, @RequestParam String dateFlight,
			@RequestParam String origin, @RequestParam String destination) {
		if(repository.existsById(numflight) && airplanerepo.existsById(planecode)) {
			repository.updateFlight(numflight, planecode, dateFlight, origin, destination);
			return "Se ha actualizado el vuelo exitosamente.";
		}else {
			return "El vuelo a actulizar no existe, o el avion a vincular no existe.";
		}
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
