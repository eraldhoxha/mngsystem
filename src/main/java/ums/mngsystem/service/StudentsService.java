package ums.mngsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ums.mngsystem.entities.Course;
import ums.mngsystem.entities.Students;
import ums.mngsystem.repository.CourseRepository;
import ums.mngsystem.repository.StudentsRepository;
import ums.mngsystem.repository.UserRepository;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository  studentsRepository;


    @Transactional
    public void saveStudents(Students student){
        studentsRepository.save(student);
    }

    @Transactional
    public void deleteStudents(Integer ID){
        if (!studentsRepository.existsById(ID)){
            throw new IllegalStateException("Student does not exist");
        }
        else
       studentsRepository.deleteById(ID);
    }
    @Transactional
    public void updateStudent(Integer ID, Students updatedStudent) {
        Students students = studentsRepository.findById(ID).orElseThrow(() -> new IllegalStateException("User not found"));

        // Update the user information
        students.setName(updatedStudent.getName());
        students.setEmail(updatedStudent.getEmail());
        // ... and so on

        studentsRepository.save(students);
    }


}
