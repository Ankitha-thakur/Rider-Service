package com.alpha.RiderService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String type;
	private String vehicleno;
	private String model;
	public vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public vehicle(String name, String type, String vehicleno, String model) {
		super();
		this.name = name;
		this.type = type;
		this.vehicleno = vehicleno;
		this.model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "vehicle [id=" + id + ", name=" + name + ", type=" + type + ", vehicleno=" + vehicleno + ", model="
				+ model + "]";
	}
}
