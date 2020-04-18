package com.airline.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.airline.model.Passenger;

@Transactional
public interface IPassengerRepo extends JpaRepository<Passenger, Integer>{

	@Query(value="select * from passenger where id=:id_passenger", nativeQuery = true)
    public List<Passenger> findPassenger(@Param("id_passenger") int id);
	
	@Query(value="SELECT passenger.* \r\n" + 
			"FROM passengerList INNER JOIN  passenger \r\n" + 
			"ON passengerList.idpassenger=passenger.id \r\n" + 
			"WHERE passengerList.numflight=:numflight", nativeQuery = true)
    public List<Passenger> listPassenger(@Param("numflight") int numflight);
	
	@Modifying
	@Query(value="INSERT INTO passenger (id, namep, birthdate, email, telephone) VALUES (:id, :namep, :birthdate, :email, :telephone)", nativeQuery = true)
    public void addPassenger(@Param("id") int id, @Param("namep") String namep, @Param("birthdate") String birthdate,
			@Param("email") String email, @Param("telephone") int telephone);
	
	@Modifying
	@Query(value="UPDATE passenger SET namep = :namep,  birthdate = :birthdate, email = :email, telephone = :telephone  WHERE id= :id", nativeQuery = true)
    public void updatePassenger(@Param("id") int id, @Param("telephone") int telephone, @Param("namep") String namep,
			@Param("birthdate") String birthdate, @Param("email") String email);
}
