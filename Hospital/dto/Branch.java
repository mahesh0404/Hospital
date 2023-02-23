package com.hospital.Hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Branch {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String address;
private String mail;

@ManyToOne
@JoinColumn
@JsonIgnore
private Hospital hospital;

@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
List<Encounter> encounter;

public List<Encounter> getEncounter() {
	return encounter;
}

public void setEncounter(List<Encounter> encounter) {
	this.encounter = encounter;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public Hospital getHospital() {
	return hospital;
}

public void setHospital(Hospital hospital) {
	this.hospital = hospital;
}
}
