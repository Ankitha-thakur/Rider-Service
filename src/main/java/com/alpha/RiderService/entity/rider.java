package com.alpha.RiderService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class rider {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int riderid;
	private String name;
	@Column(unique=true)
	private Long mobile;
	private String mail;
	private String gender;
	private int numberofRides;
	private double wallet;
	private String drivinglicense;
	private String vehicle;
	private String status;
	public rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public rider(String name, Long mobile, String mail, String gender, int numberofRides, double wallet,
			String drivinglicense, String vehicle, String status) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.mail = mail;
		this.gender = gender;
		this.numberofRides = numberofRides;
		this.wallet = wallet;
		this.drivinglicense = drivinglicense;
		this.vehicle = vehicle;
		this.status = status;
	}
	public int getRiderid() {
		return riderid;
	}
	public void setRiderid(int riderid) {
		this.riderid = riderid;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNumberofRides() {
		return numberofRides;
	}
	public void setNumberofRides(int numberofRides) {
		this.numberofRides = numberofRides;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public String getDrivinglicense() {
		return drivinglicense;
	}
	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
