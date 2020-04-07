package com.airline.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.model.Airplanes;

public interface IAirPlaneRepo extends JpaRepository<Airplanes, Integer>{

}
