package com.alpha.RiderService.dto;

import java.util.List;

public class NearbyRiderResponseDto {

    private String message;

    private List<String> riders;

    public NearbyRiderResponseDto() {
    }

    public NearbyRiderResponseDto(
            String message,
            List<String> riders) {

        this.message = message;
        this.riders = riders;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getRiders() {
        return riders;
    }

    public void setRiders(List<String> riders) {
        this.riders = riders;
    }
}