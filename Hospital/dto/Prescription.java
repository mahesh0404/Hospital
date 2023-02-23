package com.hospital.Hospital.dto;


import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.Hospital.repository.PrescriptionRepo;

@Entity
public class Prescription {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(nullable=false)
private String m_name;
@Column(nullable=false)
private int quantity;

@OneToMany(cascade=CascadeType.PERSIST,mappedBy="prescription")
List<Item>item;

@ManyToOne
@JoinColumn
@JsonIgnore
private Encounter encounter;

public List<Item> getItem() {
	return item;
}

public void setItem(List<Item> item) {
	this.item = item;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getM_name() {
	return m_name;
}

public void setM_name(String m_name) {
	this.m_name = m_name;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}



public Encounter getEncounter() {
	return encounter;
}

public void setEncounter(Encounter encounter) {
	this.encounter = encounter;
}



}
