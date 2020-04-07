package com.airline.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.model.Flights;

public interface IFlightRepo extends JpaRepository<Flights, Integer>{

}
