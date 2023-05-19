package ums.mngsystem.controller;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ums.mngsystem.entities.Faculty;
import ums.mngsystem.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {


    @Autowired
    private FacultyService facultyService;

    @PostMapping(name = "/save")
    public String saveFaculty(@RequestBody Faculty faculty){

        facultyService.saveFaculty(faculty);
        return "User "+ faculty.getName()+ " saved successfully";

    }
    @DeleteMapping(name = "/delete")

        public String deleteFaculty(@RequestParam Integer ID){

            facultyService.deleteFaculty(ID);
            return "User deleted successfully";
        }

    @PutMapping(name = "/udpate")
    public String updateFaculty(@PathVariable Integer ID, Faculty updatedFaculty){

        facultyService.updateFaculty(ID, updatedFaculty);
        return "Faculty with "+ updatedFaculty.getName()+ " is updated successfully";
    }

}
