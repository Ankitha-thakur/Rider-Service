package com.alpha.RiderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.RiderService.dto.ResponseStructure;
import com.alpha.RiderService.dto.createRiderDto;
import com.alpha.RiderService.dto.createVehicleDto;
import com.alpha.RiderService.entity.rider;
import com.alpha.RiderService.entity.vehicle;
import com.alpha.RiderService.exception.RiderNotFoundException;
import com.alpha.RiderService.exception.VehicleNotFoundException;
import com.alpha.RiderService.repository.riderrepo;
import com.alpha.RiderService.repository.vehiclerepo;

@Service
public class riderService {
	@Autowired
	private riderrepo rr;
	
	@Autowired
	private vehiclerepo vr;
	
	//rider registration
	public ResponseStructure<rider> createRider(createRiderDto crd) {
		rider r=new rider();
		r.setName(crd.getName());
		r.setDrivinglicense(crd.getDrivinglicense());
		r.setMobile(crd.getMobile());
		r.setGender(crd.getGender());
		r.setMail(crd.getMail());
		
		vehicle v=new vehicle();
		v.setName(crd.getVehicle().getName());
		v.setType(crd.getVehicle().getType());
		v.setVehicleno(crd.getVehicle().getVehicleno());
		v.setModel(crd.getVehicle().getModel());
		// Save vehicle first
	    vehicle savedVehicle = vr.save(v);

	    // Store vehicle ID in rider as String
	    r.setVehicle(String.valueOf(savedVehicle.getId()));
		
		rider savedRider=rr.save(r);
		
		ResponseStructure<rider> rs=new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Rider Saved Sucessfully");
		rs.setData(savedRider);
		return rs;
			
	}

	//finding rider by id
	public ResponseStructure<vehicle> findRider(int id) {
		rider r=rr.findById(id).orElseThrow(()-> new RiderNotFoundException());
		
		vehicle v=vr.findById(id).orElseThrow(()-> new VehicleNotFoundException());
	
		
		ResponseStructure<vehicle> rs=new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Rider Found Sucessfully");
		rs.setData(v);
		return rs;
	}

	//updating vehicle
	public ResponseStructure<vehicle> updateVehicle(int riderid, createVehicleDto cvd) {

	    rider r = rr.findById(riderid).orElseThrow(() -> new RiderNotFoundException());

	    String Id = r.getVehicle();
	    int vehicleId = Integer.parseInt(Id);

	    vehicle v = vr.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundException());

	    v.setName(cvd.getName());
	    v.setType(cvd.getType());
	    v.setVehicleno(cvd.getVehicleno());
	    v.setModel(cvd.getModel());

	    vehicle updatedVehicle = vr.save(v);

	    ResponseStructure<vehicle> rs = new ResponseStructure<>();

	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Vehicle Updated Successfully");
	    rs.setData(updatedVehicle);

	    return rs;
	}
	
	//delete rider
	public ResponseStructure<rider> deleteRider(int id) {

	    rider r = rr.findById(id).orElseThrow(() -> new RiderNotFoundException());

	    rr.delete(r);

	    ResponseStructure<rider> rs = new ResponseStructure<>();

	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Rider Deleted Successfully");
	    rs.setData(r);

	    return rs;
	}
	
	public ResponseStructure<rider> updateRiderStatus(int riderid) {

	    rider r = rr.findById(riderid).orElseThrow(() -> new RiderNotFoundException());

	    if (r.getStatus() == null) {
	        r.setStatus("INACTIVE");
	    } else {
	        r.setStatus("ACTIVE");
	    }

	    rider updatedRider = rr.save(r);

	    ResponseStructure<rider> rs = new ResponseStructure<>();
	    rs.setStatuscode(HttpStatus.OK.value());
	    rs.setMessage("Rider Status Updated Successfully");
	    rs.setData(updatedRider);

	    return rs;
	}
}
