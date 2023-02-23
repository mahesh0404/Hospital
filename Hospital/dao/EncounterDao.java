package com.hospital.Hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.Hospital.dto.Encounter;
import com.hospital.Hospital.repository.EncounterRepo;

@Repository
public class EncounterDao {
	
	@Autowired
	private EncounterRepo encounterRepo;
	
	// Create or Update an Encounter
	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}
	
	// Read an Encounter by ID
	public Optional<Encounter> getEncounterById(int id) {
		return encounterRepo.findById(id);
	}
	
	// Delete an Encounter by ID
	public void deleteEncounterById(int id) {
		encounterRepo.deleteById(id);
	}
	
	// Read all Encounters
	public List<Encounter> getAllEncounters() {
		return encounterRepo.findAll();
	}
	
}
