package com.hospital.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital.dto.Branch;
import com.hospital.Hospital.dto.Patients;

public interface PatientsRepo extends JpaRepository<Patients, Integer>{

}
