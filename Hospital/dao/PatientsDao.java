package com.hospital.Hospital.dao;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.Hospital.dto.Patients;
import com.hospital.Hospital.repository.PatientsRepo;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientsDao {
    @Autowired
    private PatientsRepo patientsRepo;

    public List<Patients> findAll() {
        return patientsRepo.findAll();
    }

    public Optional<Patients> getPatientById(int id) {
        return patientsRepo.findById(id);
    }

    public Patients save(Patients patient) {
        return patientsRepo.save(patient);
    }

    public void deleteById(int id) {
        patientsRepo.deleteById(id);
    }

    public Optional<Patients> findById(int id) {
        return patientsRepo.findById(id);
    }
}
