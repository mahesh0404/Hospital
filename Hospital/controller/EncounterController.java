package com.hospital.Hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital.dao.BranchDao;
import com.hospital.Hospital.dao.EncounterDao;
import com.hospital.Hospital.dto.Branch;
import com.hospital.Hospital.dto.Encounter;
import com.hospital.Hospital.repository.EncounterRepo;

@RestController
@RequestMapping("/encounters")
public class EncounterController {

    @Autowired
    private EncounterDao encounterDao;

    @GetMapping("/{id}")
    public Encounter getEncounterById(@PathVariable int id) {
        return encounterDao.getEncounterById(id).orElse(null);
    }

    @PostMapping("/add")
    public Encounter addEncounter(@RequestBody Encounter encounter) {
        return encounterDao.saveEncounter(encounter);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEncounter(@PathVariable int id) {
        encounterDao.deleteEncounterById(id);
    }

    @GetMapping("/all")
    public List<Encounter> getAllEncounters() {
        return encounterDao.getAllEncounters();
    }
    @Autowired 
    EncounterRepo encounterRepo;
   @PostMapping("/update")
   public Encounter updatedatabyid(@RequestBody Encounter encounter) {
	     int id = encounter.getId();
	     Optional<Encounter> optionalEncounter = encounterRepo.findById(id);
	     if(optionalEncounter.isPresent()) {
	    	 
	     Encounter existingEncounter = optionalEncounter.get();
	        existingEncounter.setCause(encounter.getCause());
	        existingEncounter.setBloodGroup(encounter.getBloodGroup());
	        return encounterRepo.save(existingEncounter);
	     }
	     else
	     {
	    	 return null;
	     }
	   
   }
//   @Autowired
//   BranchDao branchDao;
//   @PostMapping("/encounterwithbranch")
//   public Encounter addwithbranch(@RequestBody Encounter encounter) {
//       // Set the branch for the encounter
//       Branch branch = encounter.getBranch();
//       if (branch != null) {
//           int branchId = branch.getId();
//           branch = branchDao.getBranchById(branchId).orElse(null);
//           encounter.setBranch(branch);
//       }
//       // Save the encounter
//       return encounterDao.saveEncounter(encounter);
//   }

}
