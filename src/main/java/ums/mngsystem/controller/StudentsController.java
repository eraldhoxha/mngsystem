package ums.mngsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ums.mngsystem.entities.Students;
import ums.mngsystem.repository.StudentsRepository;
import ums.mngsystem.service.StudentsService;

import javax.persistence.Id;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @PostMapping(path = "/save", consumes = "application/json")
    public String saveStudent(@RequestBody Students students){

        studentsService.saveStudents(students);
        return "User "+ students.getName() + " saved successfully";
    }
    @DeleteMapping(path = "/delete")
    public String deleteStudent(@RequestParam Integer ID){
        try {
            studentsService.deleteStudents(ID);
            return "Student deleted successfully";
        }
        catch (Exception e) {
            return "Error";
        }

    }

    @PutMapping(path = "/update")
    public String updateStudent(@PathVariable Integer ID, @RequestBody Students updatedStudent){

        studentsService.updateStudent(ID, updatedStudent);
        return "User "+ updatedStudent.getName()+ " updated succerssfully";
    }
}
