package ums.mngsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ums.mngsystem.entities.Course;
import ums.mngsystem.entities.Enrollment;
import ums.mngsystem.entities.Faculty;
import ums.mngsystem.entities.Students;
import ums.mngsystem.repository.*;

import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    GradesRepository gradesRepository;
    @Autowired
    CourseRepository courseRepository;

    public void requestEnrollment(Integer studentId, Integer courseId, Integer facultyId) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent_id(studentId);
        enrollment.setFaculty_id(facultyId);
        enrollment.setCourse_id(courseId);
        enrollment.setApproved((byte) 0);
        enrollmentRepository.save(enrollment);
    }

    @Transactional
    public void getPendingEnrollments(Integer enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment.isPresent()) {
            enrollment.get().setApproved((byte) 1);

        }
        else {
            throw new IllegalStateException("No enrollment exists with this enrollmentId");
        }
    }

@Transactional
    public void deleteEnrollment(Integer enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElseThrow(() -> new IllegalStateException("Enrollment not found"));
        enrollmentRepository.delete(enrollment);
    }
@Transactional
    public void updateEnrollment(Integer enrollmentId, Integer courseId, Integer facultyId){
        Optional<Enrollment> enrollment = enrollmentRepository.findById(enrollmentId);
        Optional<Course> course = courseRepository.findById(courseId);
        Optional<Faculty> faculty = facultyRepository.findById(facultyId);
        if (!enrollment.isPresent()){
            throw new IllegalStateException("Enrollment is not present");
        }
        if (!course.isPresent()) {
        throw new IllegalStateException("Course is not present");
        }
    if (!faculty.isPresent()) {
        throw new IllegalStateException("Faculty is not present");
    }
    course.get().setCourseId(courseId);
    faculty.get().setFacultyId(facultyId);

    }
}



