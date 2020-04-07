package com.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplanes {

	@Id
	private int planecode;
	private String description;
	private int capacity;
	
	
	public int getPlanecode() {
		return planecode;
	}
	public void setPlanecode(int planecode) {
		this.planecode = planecode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
