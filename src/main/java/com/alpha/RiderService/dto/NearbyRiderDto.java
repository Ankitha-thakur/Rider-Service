package com.alpha.RiderService.dto;

public class NearbyRiderDto {

    private String vehicleType;

    private double latitude;

    private double longitude;

    private double radiusInKm;

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

    public double getRadiusInKm() {
        return radiusInKm;
    }

    public void setRadiusInKm(double radiusInKm) {
        this.radiusInKm = radiusInKm;
    }
}