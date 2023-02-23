package com.hospital.Hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.Hospital.dto.Branch;
import com.hospital.Hospital.repository.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepo branchRepo;
	
	// Create or Update a branch
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	
	
	// Read a branch by ID
	public Optional<Branch> getBranchById(int id) {
		return branchRepo.findById(id);
	}
	
	// Delete a branch by ID
	public void deleteBranchById(int id) {
		branchRepo.deleteById(id);
	}
	
	// Read all branches
	public List<Branch> getAllBranches() {
		return branchRepo.findAll();
	}
}
