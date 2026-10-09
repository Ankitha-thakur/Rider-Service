package com.alpha.RiderService.dto;

public class BookingDto {

    private int id;

    private int customerId;

    private int riderId;

    private CoordinateDto source;

    private CoordinateDto destination;

    private String vehicleType;

    private String paymentType;

    private String status;

    private double fare;

    private int otp;

    public BookingDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public CoordinateDto getSource() {
        return source;
    }

    public void setSource(CoordinateDto source) {
        this.source = source;
    }

    public CoordinateDto getDestination() {
        return destination;
    }

    public void setDestination(CoordinateDto destination) {
        this.destination = destination;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}