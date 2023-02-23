package com.hospital.Hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.Hospital.dto.Prescription;
import com.hospital.Hospital.repository.PrescriptionRepo;

@Repository
public class PrescriptionDao {

	@Autowired
	private PrescriptionRepo prescriptionRepo;

	// Create or Update a prescription
	public Prescription savePrescription(Prescription prescription) {
		return prescriptionRepo.save(prescription);
	}

	// Read a prescription by ID
	public Optional<Prescription> getPrescriptionById(int id) {
		return prescriptionRepo.findById(id);
	}

	// Delete a prescription by ID
	public void deletePrescriptionById(int id) {
		prescriptionRepo.deleteById(id);
	}

	// Read all prescriptions
	public List<Prescription> getAllPrescriptions() {
		return prescriptionRepo.findAll();
	}
	//Update a prescription

	public Prescription updatePrescription(Prescription prescription) {
	 Optional<Prescription> prescriptionOptional = prescriptionRepo.findById(prescription.getId());
	 if (prescriptionOptional.isPresent()) {
	     Prescription updatedPrescription = prescriptionOptional.get();
	     updatedPrescription.setM_name(prescription.getM_name());
	     updatedPrescription.setQuantity(prescription.getQuantity());
	     updatedPrescription.setItem(prescription.getItem());
	     updatedPrescription.setEncounter(prescription.getEncounter());
	     return prescriptionRepo.save(updatedPrescription);
	 } else {
	     return null;
	 }
	}

}
