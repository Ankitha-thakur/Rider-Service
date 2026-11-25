package com.alpha.RiderService.dto;

public class CurrentLocationDto {

    private int riderId;

    private String vehicleType;

    private double latitude;

    private double longitude;

    public CurrentLocationDto() {
    }

    public CurrentLocationDto(
            int riderId,
            String vehicleType,
            double latitude,
            double longitude) {

        this.riderId = riderId;
        this.vehicleType = vehicleType;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
