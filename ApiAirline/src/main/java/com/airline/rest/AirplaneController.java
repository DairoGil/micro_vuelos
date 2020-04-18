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
	public @ResponseBody String addNewAirplane(@RequestParam String description, @RequestParam int capacity) {
		Airplanes airplane = new Airplanes();
		airplane.setDescription(description);
		airplane.setCapacity(capacity);
		repository.save(airplane);
		return "Se ha creado el avión satisfactoriamente.";
	}
	
	@PostMapping(path = "/update")
	public @ResponseBody String updateFlight(@RequestParam int planecode, @RequestParam String description,
			@RequestParam int capacity) {
		if(repository.existsById(planecode)) {
			Airplanes airplane = new Airplanes();
			airplane.setPlanecode(planecode);
			airplane.setDescription(description);
			airplane.setCapacity(capacity);
			repository.save(airplane);
			return "Se ha actualizado la información del avión.";
		}else {
			return "El avión a actualizar no existe.";
		}
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

}
