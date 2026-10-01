package com.alpha.RiderService.dto;

public class createRiderDto {
	private String name;
	private Long mobile;
	private String gender;
	private String mail;
	private String drivinglicense;
	private createVehicleDto vehicle;
	public createRiderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public createRiderDto(String name, Long mobile, String gender, String mail, String drivinglicense,
			createVehicleDto vehicle) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.gender = gender;
		this.mail = mail;
		this.drivinglicense = drivinglicense;
		this.vehicle = vehicle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDrivinglicense() {
		return drivinglicense;
	}
	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}
	public createVehicleDto getVehicle() {
		return vehicle;
	}
	public void setVehicle(createVehicleDto vehicle) {
		this.vehicle = vehicle;
	}
	
}
