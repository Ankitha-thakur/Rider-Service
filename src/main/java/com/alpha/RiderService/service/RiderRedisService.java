package com.alpha.RiderService.service;

import java.util.ArrayList;
import java.util.List;

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
}