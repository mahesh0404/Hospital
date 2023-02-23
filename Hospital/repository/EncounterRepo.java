package com.hospital.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital.dto.Branch;
import com.hospital.Hospital.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

}
