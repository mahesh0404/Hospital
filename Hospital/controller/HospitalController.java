package com.hospital.Hospital.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Hospital.dao.HospitalDao;
import com.hospital.Hospital.dto.Hospital;
import com.hospital.Hospital.repository.HospitalRepo;

@RestController  // used for making restful services and used at the class level
// allows to handle request made by the client
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	HospitalDao hosDao;
	@Autowired
	HospitalRepo hospitalRepo;
	@PostMapping("/insert")
	public Hospital saveData(@RequestBody Hospital hospital)
	{
		return hosDao.saveHospital(hospital);
	}
	
	@GetMapping("/getbyid/{id}")
	public Hospital getHosById(@PathVariable int id) {
		Optional<Hospital> ho = hosDao.getHosById(id);
		if(ho.isEmpty())
			return null;
		else
			return ho.get();
	}
	

	@GetMapping("/getall")
	public List<Hospital> getAllHos() {
	    return hospitalRepo.findAll();
	}

	@PostMapping("/update")
	public Hospital updateHos(@RequestBody Hospital hospital) {
	    Optional<Hospital> ho = hospitalRepo.findById(hospital.getId());
	    if(ho.isEmpty())
	        return null;
	    else {
	        Hospital existingHospital = ho.get();
	        existingHospital.setName(hospital.getName());
	        existingHospital.setAddress(hospital.getAddress());
	        return hospitalRepo.save(existingHospital);
	    }
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteHosById(@PathVariable int id) {
	    hospitalRepo.deleteById(id);
	}
	}
    

