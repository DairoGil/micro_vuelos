package com.airline.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.model.Passengerlist;

public interface IPassengerListRepo extends JpaRepository<Passengerlist, Integer>{

}
