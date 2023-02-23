package com.hospital.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital.dto.Branch;
import com.hospital.Hospital.dto.Encounter;
import com.hospital.Hospital.dto.Prescription;

public interface PrescriptionRepo extends JpaRepository<Prescription, Integer>{

}
