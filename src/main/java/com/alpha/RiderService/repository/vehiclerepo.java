package com.alpha.RiderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.RiderService.entity.vehicle;

@Repository
public interface vehiclerepo extends JpaRepository<vehicle,Integer>{

}
