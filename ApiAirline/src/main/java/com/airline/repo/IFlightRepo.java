package com.airline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.airline.model.Flights;

@Transactional
public interface IFlightRepo extends JpaRepository<Flights, Integer>{

	@Modifying
	@Query(value="INSERT INTO flights (planecode, dateflight, origin, destination) VALUES (:planecode, :dateFlight, :origin, :destination)", nativeQuery = true)
    public void addFlight(@Param("planecode") int planecode, @Param("dateFlight") String dateFlight,
			@Param("origin") String origin, @Param("destination") String destination);
	
	@Modifying
	@Query(value="UPDATE flights SET planecode = :planecode,  dateflight = :dateFlight, origin = :origin, destination = :destination  WHERE numflight= :numflight", nativeQuery = true)
    public void updateFlight(@Param("numflight") int numflight, @Param("planecode") int planecode, @Param("dateFlight") String dateFlight,
			@Param("origin") String origin, @Param("destination") String destination);
}
