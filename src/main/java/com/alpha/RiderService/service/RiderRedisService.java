package com.alpha.RiderService.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alpha.RiderService.dto.CurrentLocationDto;
import com.alpha.RiderService.dto.NearbyRiderDto;
import com.alpha.RiderService.dto.NearbyRiderResponseDto;

@Service
public class RiderRedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RiderRedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Save rider current location in Redis
    public void saveCurrentLocation(CurrentLocationDto dto) {

        int riderId = dto.getRiderId();

        String vehicleType = dto.getVehicleType();

        double latitude = dto.getLatitude();

        double longitude = dto.getLongitude();

        // Example:
        // riders:BIKE
        // riders:AUTO
        // riders:CAR
        String key = "riders:" + vehicleType.toUpperCase();

        // Redis Point = longitude, latitude
        Point point = new Point(longitude, latitude);

        String riderIdString = String.valueOf(riderId);

        // Store rider ID with its location
        redisTemplate.opsForGeo().add(
                key,
                point,
                riderIdString
        );
    }
 // Find nearby riders
    public NearbyRiderResponseDto findNearbyRiders(NearbyRiderDto dto) {

        String vehicleType = dto.getVehicleType();
        double latitude = dto.getLatitude();
        double longitude = dto.getLongitude();
        double radiusInKm = dto.getRadiusInKm();

        // Redis key
        String key = "riders:" + vehicleType.toUpperCase();

        // Customer location
        Point customerLocation =
                new Point(longitude, latitude);

        // Radius
        Distance radius =
                new Distance(
                        radiusInKm,
                        Metrics.KILOMETERS
                );

        // Search area
        Circle searchArea =
                new Circle(
                        customerLocation,
                        radius
                );

        // Search Redis
        GeoResults<RedisGeoCommands.GeoLocation<Object>> results =
                redisTemplate.opsForGeo().radius(
                        key,
                        searchArea
                );

        // List of nearby riders
        List<String> riders = new ArrayList<>();

        if (results != null) {

            for (
                    GeoResult<RedisGeoCommands.GeoLocation<Object>> result
                    : results.getContent()
            ) {

                // Get rider ID
                String riderId =
                        String.valueOf(
                                result.getContent().getName()
                        );

                riders.add(riderId);
            }
        }

        // No riders
        if (riders.isEmpty()) {

            return new NearbyRiderResponseDto(
                    "No nearby riders found",
                    riders
            );
        }

        // Riders found
        return new NearbyRiderResponseDto(
                "Nearby riders found",
                riders
        );
    }

    public void assignBookingToRider(int riderId,int bookingId,double fare,double distance) {

        String key = "assignedRides:" + riderId;

        String bookingDetails =
                "{\"fare\":" + fare +
                ",\"distance\":" + distance + "}";

        redisTemplate.opsForHash().put(
                key,
                String.valueOf(bookingId),
                bookingDetails);
    }
    
    
    public List<Map<Object, Object>> findAssignedRider(int riderId) {

        String key = "assignedRides:" + riderId;

        Map<Object, Object> bookings =
                redisTemplate.opsForHash().entries(key);

        List<Map<Object, Object>> result = new ArrayList<>();

        for (Map.Entry<Object, Object> entry : bookings.entrySet()) {

            Map<Object, Object> booking =new HashMap<>();

            booking.put("bookingId", entry.getKey());
            booking.put("bookingDetails", entry.getValue());

            result.add(booking);
        }

        return result;
    }
    
    public void removeAssignedBooking(int riderId, int bookingId) {

        String key = "assignedRides:" + riderId;

        redisTemplate.opsForHash().delete(
                key,
                String.valueOf(bookingId)
        );
    }
    private void removeBookingFromOtherRiders(
            int acceptedRiderId,
            int bookingId) {

        Set<String> keys =
                redisTemplate.keys("assignedRides:*");

        if (keys == null) {
            return;
        }

        for (String key : keys) {

            String riderIdString =
                    key.substring("assignedRides:".length());

            int riderId =
                    Integer.parseInt(riderIdString);

            // Don't remove from the rider who accepted
            if (riderId == acceptedRiderId) {
                continue;
            }

            redisTemplate.opsForHash().delete(
                    key,
                    String.valueOf(bookingId)
            );
        }
    }
    public String acceptBooking(int riderId, int bookingId) {

        String riderKey = "assignedRides:" + riderId;

        // Check whether this booking exists for this rider
        Boolean exists = redisTemplate.opsForHash()
                .hasKey(
                        riderKey,
                        String.valueOf(bookingId)
                );

        if (!Boolean.TRUE.equals(exists)) {

            return "Booking " + bookingId +
                    " is not assigned to rider " + riderId;
        }

        // Remove booking from this rider's pending list
        redisTemplate.opsForHash().delete(
                riderKey,
                String.valueOf(bookingId)
        );

        // Remove booking from all other riders
        removeBookingFromOtherRiders(
                riderId,
                bookingId
        );

        return "Booking " + bookingId +
                " accepted by rider " + riderId;
    }
}