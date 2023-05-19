package ums.mngsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import ums.mngsystem.entities.Faculty;
import ums.mngsystem.repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Transactional
    public void saveFaculty(Faculty faculty){
        facultyRepository.save(faculty);
    }

    @Transactional
    public void deleteFaculty( Integer ID){

        facultyRepository.deleteById(ID);
    }

    @Transactional
    public void updateFaculty(Integer ID, Faculty updatedFaculty){
        Faculty faculty = facultyRepository.findById(ID).orElseThrow(() -> new IllegalStateException("User not found"));

        // Update the user information
        faculty.setName(updatedFaculty.getName());
        faculty.setEmail(updatedFaculty.getEmail());
        // ... and so on

        facultyRepository.save(faculty);

    }
}
