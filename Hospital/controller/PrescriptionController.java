package com.hospital.Hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital.dao.PrescriptionDao;
import com.hospital.Hospital.dto.Prescription;
import com.hospital.Hospital.repository.PrescriptionRepo;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {
	
	@Autowired
	PrescriptionDao prescriptionDao;
	
	@GetMapping("/{id}")
	public Prescription getPrescriptionById(@PathVariable int id ){
		return prescriptionDao.getPrescriptionById(id).orElse(null);
	}
	
	@PostMapping("/add")
	public Prescription addPrescription(@RequestBody Prescription prescription){
		
		return prescriptionDao.savePrescription(prescription);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public void deletePrescription(@PathVariable int id){
		prescriptionDao.deletePrescriptionById(id);
	}
	
	@GetMapping("/getall")
	public List<Prescription> getAllPrescriptions(){
		return prescriptionDao.getAllPrescriptions();
	}

	@PostMapping("/update")
	public Prescription updatedata(@RequestBody Prescription prescription)
	{
		return prescriptionDao.updatePrescription(prescription);
	   
	   
	}

}
