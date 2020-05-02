package com.airline.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flights {

	@Id
	private int numflight;
	private int planecode;
	private String dateflight;
	private String origin;
	private String destination;
	
	public int getNumVuelo() {
		return numflight;
	}
	public void setNumVuelo(int numVuelo) {
		this.numflight = numVuelo;
	}
	public int getPlanecode() {
		return planecode;
	}
	public void setPlanecode(int planecode) {
		this.planecode = planecode;
	}
	public String getDateflight() {
		return dateflight;
	}
	public void setDateflight(String dateflight) {
		this.dateflight = dateflight;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
