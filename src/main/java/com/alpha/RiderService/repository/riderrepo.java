package com.alpha.RiderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.RiderService.entity.rider;

@Repository
public interface riderrepo extends JpaRepository<rider,Integer>{

}
