package com.airline.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.airline.model.Passenger;

@Transactional
public interface IPassengerRepo extends JpaRepository<Passenger, Integer>{

	@Query(value="select * from passenger where id=:id_passenger", nativeQuery = true)
    public List<Passenger> findPassenger(@Param("id_passenger") int id);
}
