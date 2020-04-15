package com.airline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.airline.model.Passengerlist;

@Transactional
public interface IPassengerListRepo extends JpaRepository<Passengerlist, Integer>{

	@Modifying
	@Query(value="INSERT INTO passengerlist (numflight, idpassenger) VALUES (:numflight, :idpassenger)", nativeQuery = true)
    public void addPassenger(@Param("numflight") int numflight, @Param("idpassenger") int idpassenger);
}
