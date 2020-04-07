package com.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passengerlist {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int numflight;
	private int idpassenger;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumFlight() {
		return numflight;
	}
	public void setNumFlight(int numFlight) {
		this.numflight = numFlight;
	}
	public int getIdPassenger() {
		return idpassenger;
	}
	public void setIdPassenger(int idPassenger) {
		this.idpassenger = idPassenger;
	}
}
