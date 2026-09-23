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
	private int id;
	private String name;
	@Column(unique=true)
	private Long mobile;
	private String mail;
	private String gender;
	private int numberofRides;
	private double wallet;
	private String drivinglicense;
	private Long vehicleId;
	public rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public rider(String name, Long mobile, String mail, String gender, int numberofRides, double wallet,
			String drivinglicense, Long vehicleId) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.mail = mail;
		this.gender = gender;
		this.numberofRides = numberofRides;
		this.wallet = wallet;
		this.drivinglicense = drivinglicense;
		this.vehicleId = vehicleId;
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
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	@Override
	public String toString() {
		return "rider [id=" + id + ", name=" + name + ", mobile=" + mobile + ", mail=" + mail + ", gender=" + gender
				+ ", numberofRides=" + numberofRides + ", wallet=" + wallet + ", drivinglicense=" + drivinglicense
				+ ", vehicleId=" + vehicleId + "]";
	}
	
	
}
