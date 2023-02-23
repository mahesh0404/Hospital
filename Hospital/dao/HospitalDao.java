package com.hospital.Hospital.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.Hospital.dto.Branch;
import com.hospital.Hospital.dto.Hospital;
import com.hospital.Hospital.repository.BranchRepo;
import com.hospital.Hospital.repository.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	HospitalRepo hospitalRepo;
	@Autowired
	BranchRepo branchRepo;
	
	public Hospital saveHospital(Hospital hospital)
	{
	
			List<Branch>listofbranches = hospital.getBranch();
		    List<Branch> list = new ArrayList<>();
		
		    if(listofbranches.isEmpty())
		    {
		    	hospital = hospitalRepo.save(hospital);
		    	
		    }
		    else
		    {
		    	hospital = hospitalRepo.save(hospital);
		    	for(Branch branch : listofbranches) {
		    		branch.setHospital(hospital);
		    		list.add(branchRepo.save(branch));
		    	}
		    	hospital.setBranch(list);
		    }
		    return hospital;
	    
	
	}

	
	

	public Optional<Hospital> getHosById(int id) {
		return hospitalRepo.findById(id);
	}
    
}