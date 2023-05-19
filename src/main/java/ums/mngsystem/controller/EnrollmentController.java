package ums.mngsystem.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ums.mngsystem.entities.Enrollment;
import ums.mngsystem.entities.Students;
import ums.mngsystem.service.EnrollmentService;
import ums.mngsystem.service.StudentsService;

@RestController("/enrollment")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;
    @Autowired
    StudentsService studentsService;

    @PutMapping(value = "/request")
    public String requestEnrollment(@RequestParam Integer studentId, @RequestParam Integer courseId, @RequestParam Integer facultyId) {
        enrollmentService.requestEnrollment(studentId, courseId, facultyId);
        return "Enrollment request successfully";
    }

    @PutMapping(name = "/pending")
    public String getPendingEnrollments(@RequestParam Integer enrollmentId) {
        enrollmentService.getPendingEnrollments(enrollmentId);
        return "Enrollment approved";
    }

    @DeleteMapping(name = "/delete")
        public String deleteEnrollment(@RequestParam Integer enrollmentId){
            try {
                enrollmentService.deleteEnrollment(enrollmentId);
                return "Enrollment deleted successfully";
            } catch (Exception e) {
                return "Error";
            }
        }

    @PutMapping(value = "/updateEnrollment")
        public String updateEnrollment(@RequestParam Integer enrollmentId, @RequestParam Integer courseId, @RequestParam Integer facultyId){

        enrollmentService.updateEnrollment(enrollmentId, courseId, facultyId);

        return "Enrollment updated successfully";
    }
}


