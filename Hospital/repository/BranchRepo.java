package com.hospital.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.Hospital.dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer>{

}
