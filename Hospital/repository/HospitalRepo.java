package com.hospital.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital,Integer> {
    
	
}
