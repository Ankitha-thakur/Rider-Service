package com.alpha.RiderService.dto;

public class NearbyRiderLocationDto {

    private int riderId;
    private double latitude;
    private double longitude;

    public NearbyRiderLocationDto() {
        super();
    }

    public NearbyRiderLocationDto(
            int riderId,
            double latitude,
            double longitude) {

        this.riderId = riderId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
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