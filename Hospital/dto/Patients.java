package com.hospital.Hospital.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patients {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 @Override
	public String toString() {
		return "Patients [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	@Column(nullable = true)
	private String name;
	 @Column(nullable = true, unique=false)
	private long phone;
	
	@OneToMany(mappedBy="patients")
	List<Encounter> encounter;

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public List<Encounter> getEncounter() {
		return encounter;
	}

	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}

	
	
}
