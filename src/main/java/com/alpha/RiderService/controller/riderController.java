package com.alpha.RiderService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.RiderService.dto.CurrentLocationDto;
import com.alpha.RiderService.dto.NearbyRiderDto;
import com.alpha.RiderService.dto.NearbyRiderResponseDto;
import com.alpha.RiderService.dto.ResponseStructure;
import com.alpha.RiderService.dto.createRiderDto;
import com.alpha.RiderService.dto.createVehicleDto;
import com.alpha.RiderService.entity.rider;
import com.alpha.RiderService.entity.vehicle;
import com.alpha.RiderService.service.RiderRedisService;
import com.alpha.RiderService.service.riderService;

@RestController
public class riderController {
	@Autowired
	private RiderRedisService riderRedisService ;
	
	@Autowired
	private riderService riderservice;
	
	@PostMapping("/rider/create")
	public ResponseStructure<rider> createRider(@RequestBody createRiderDto crd) {
		return riderservice.createRider(crd);
	}
	
	@GetMapping("/rider/find")
	public ResponseStructure<vehicle> findRider(@RequestParam int id) {
		return riderservice.findRider(id);
	}

	@PatchMapping("/vehicle/update")
	public ResponseStructure<vehicle> updateVehicle(@RequestParam int id,@RequestBody createVehicleDto cvd) {
	    return riderservice.updateVehicle(id, cvd);
	}
	
	@DeleteMapping("/rider/delete")
	public ResponseStructure<rider> deleteRider(@RequestParam int id) {
	    return riderservice.deleteRider(id);
	}
	
	@PatchMapping("/rider/status")
	public ResponseStructure<rider> updateRiderStatus( @RequestParam int riderid) {
	    return riderservice.updateRiderStatus(riderid);
	}
	
	@PostMapping("/sendCurrentLocation")
    public String sendCurrentLocation(@RequestBody CurrentLocationDto dto) {

		riderRedisService.saveCurrentLocation(dto);

        return "Current location saved successfully";
    }
	
	@PostMapping("/rider/nearby")
	public NearbyRiderResponseDto findNearbyRiders(
	        @RequestBody NearbyRiderDto dto) {

	    return riderRedisService.findNearbyRiders(dto);
	}
	
	@PostMapping("/rider/assignBooking")
	public String assignBooking(
	        @RequestParam int riderId,
	        @RequestParam int bookingId,
	        @RequestParam double fare,
	        @RequestParam double distance) {

	    riderRedisService.assignBookingToRider(
	            riderId,
	            bookingId,
	            fare,
	            distance
	    );

	    return "Booking assigned successfully";
	}
	
	
	@GetMapping("/rider/getallAssignedruder/{riderid}")
	public List<Map<Object, Object>> findAssignedRider(@PathVariable int riderid) {
	    return riderRedisService.findAssignedRider(riderid);
	}
	
	@DeleteMapping("/rider/assignedBooking")
	public String removeAssignedBooking(
	        @RequestParam int riderId,
	        @RequestParam int bookingId) {

	    riderRedisService.removeAssignedBooking(riderId, bookingId);

	    return "Booking removed from rider successfully";
	}
	
}

