package com.hospital.Hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Encounter {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
  
	@Column(nullable = true)
	private String cause;
    @Column(nullable = true)
	private String bloodGroup;
	
    @OneToMany(mappedBy="encounter",cascade=CascadeType.PERSIST)
    List<Prescription>prescription;
    
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Branch branch;

   public List<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}

public Patients getPatients() {
		return patients;
	}

	public void setPatients(Patients patients) {
		this.patients = patients;
	}

@ManyToOne(cascade=CascadeType.PERSIST)
   @JoinColumn
   private Patients patients;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCause() {
	return cause;
}

public void setCause(String cause) {
	this.cause = cause;
}

public String getBloodGroup() {
	return bloodGroup;
}

public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}

public Branch getBranch() {
	return branch;
}

public void setBranch(Branch branch) {
	this.branch = branch;
}


   
}