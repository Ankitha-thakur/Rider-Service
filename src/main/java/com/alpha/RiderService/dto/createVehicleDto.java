package com.alpha.RiderService.dto;

public class createVehicleDto {
	private String name;
	private String type;
	private String vehicleno;
	private String model;
	public createVehicleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public createVehicleDto(String name, String type, String vehicleno, String model) {
		super();
		this.name = name;
		this.type = type;
		this.vehicleno = vehicleno;
		this.model = model;
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
	

}
