package com.ispan.model;

import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "cars")
@Component
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private String make;
	private String model;
	private Year year;
	private Float displacemen;
	private Integer seat;
	
	public Car() {
		super();
	}
	
	public Car(String type, String make, String model, Year year, Float displacemen, Integer seat) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.year = year;
		this.displacemen = displacemen;
		this.seat = seat;
	}
	public Car(Integer id, String type, String make, String model, Year year, Float displacemen, Integer seat) {
		this.id = id;
		this.type = type;
		this.make = make;
		this.model = model;
		this.year = year;
		this.displacemen = displacemen;
		this.seat = seat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public Float getDisplacemen() {
		return displacemen;
	}
	public void setDisplacemen(Float displacemen) {
		this.displacemen = displacemen;
	}
	public Integer getSeat() {
		return seat;
	}
	public void setSeat(Integer seat) {
		this.seat = seat;
	}
	
}
