package ums.mngsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ums.mngsystem.entities.Course;
import ums.mngsystem.entities.Faculty;
import ums.mngsystem.repository.CourseRepository;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    public void saveCourse(Course course){
        Optional<Course> course1 = courseRepository.findByName(course.getName());
        if (course1.isPresent()){
            throw new IllegalStateException("Course is taken");
        }
        courseRepository.save(course);
    }
    @Transactional
    public void deleteCourse(Integer courseId){
        if(!courseRepository.existsById(courseId)){
            throw new IllegalStateException("Course does not exist");
        }
        Optional<Course> course = courseRepository.findById(courseId);
        course.get().setEnabled((byte) 0);
    }

    public void updateCourse(Integer courseId, Course updatedCourse ){
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalStateException("User not found"));

        // Update the course information
        course.setName(updatedCourse.getName());
        // ... and so on

        courseRepository.save(course);


    }
}
