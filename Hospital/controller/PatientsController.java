package com.hospital.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital.dao.PatientsDao;
import com.hospital.Hospital.dto.Patients;
import com.hospital.Hospital.repository.PatientsRepo;

@RestController
@RequestMapping("/patients")
public class PatientsController {
	
	@Autowired
	private PatientsDao patientsDao;
	
	@Autowired
	private PatientsRepo patientsRepo;
	
	@GetMapping("/{id}")
	public Patients getPatientById(@PathVariable int id){
		return patientsDao.findById(id).orElse(null);
	}
	
	@PostMapping("/add")
	public Patients addPatient(@RequestBody Patients patient){
		return patientsDao.save(patient);
	}
	
	@PutMapping("/{id}")
	public Patients updatePatient(@PathVariable int id, @RequestBody Patients patient) {
		return patientsDao.findById(id).map(existingPatient -> {
			existingPatient.setName(patient.getName());
			existingPatient.setPhone(patient.getPhone());
			return patientsDao.save(existingPatient);
		}).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable int id){
		patientsDao.deleteById(id);
	}
	
	@GetMapping("/all")
	public List<Patients> getAllPatients(){
		return patientsDao.findAll();
	}
	
	
	

}
