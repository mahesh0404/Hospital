package com.hospital.Hospital.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.Hospital.dao.BranchDao;
import com.hospital.Hospital.dao.HospitalDao;

import com.hospital.Hospital.dto.Branch;
import com.hospital.Hospital.dto.Encounter;
import com.hospital.Hospital.repository.BranchRepo;
import com.hospital.Hospital.repository.EncounterRepo;

@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	HospitalDao hospitalDao;
	
      
 
	
//	@PutMapping("/updatebranch/{hospitalId}")
//	public Branch insert(@PathVariable int hospitalId, @RequestBody Branch branch) {
//	    Optional<Hospital> optionalHospital = hospitalDao.getHosById(hospitalId);
//	    if (optionalHospital.isPresent()) {
//	        Hospital hospital = optionalHospital.get();
//	        branch.setHospital(hospital);
//	        return branchDao.saveBranch(branch);
//	    } else {
//	        throw new RuntimeException("Hospital not found");
//	    }
//	}
	@GetMapping("/getall")
	public List<Branch> getAllBranches() {
	    List<Branch> branches = branchDao.getAllBranches();
	    if (branches.isEmpty()) {
	        return null;
	    } else {
	        return branches;
	    }
	}
    
	// Update a branch by ID
	@PostMapping("/update") 
	public Branch updateBranchById(@RequestBody Branch branch) {
		     int id = branch.getId();
	    Optional<Branch> optionalBranch = branchRepo.findById(id);
	    if (optionalBranch.isPresent()) {
	        Branch existingBranch = optionalBranch.get();
	        existingBranch.setName(branch.getName());
	        existingBranch.setAddress(branch.getAddress());
	        existingBranch.setMail(branch.getMail());
	        
	        
	        return branchRepo.save(existingBranch);
	    } else {
	        return null;
	    }
	}


	
	@GetMapping("/get/{id}")
	public Branch getBranchById(@PathVariable int id) {
		Optional<Branch> branch = branchDao.getBranchById(id);
		if(branch.isEmpty())
			return null;
		else
			return branch.get();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable int id)
	{
		branchRepo.deleteById(id);
		
	}
	
	
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	EncounterRepo encounterRepo;
	@PostMapping("/insert")
	public Branch insert(@RequestBody Branch branch) {
		List<Encounter> encounterlist = branch.getEncounter();
		List<Encounter> enc = new ArrayList<>();
		if(encounterlist.isEmpty())
		{
			branch = branchRepo.save(branch);
		
		}
		else
		{
			branch = branchRepo.save(branch);
			for(Encounter encounter:encounterlist)
			{
				encounter.setBranch(branch);
				enc.add(encounterRepo.save(encounter));
			
			}
			branch.setEncounter(enc);
			
		}
		
		return branch;
	}
}
