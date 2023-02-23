package com.hospital.Hospital.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(nullable=false)
private int count;
@ManyToOne
@JoinColumn
private Prescription prescription;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public Prescription getPrescription() {
	return prescription;
}
public void setPrescription(Prescription prescription) {
	this.prescription = prescription;
}

}
