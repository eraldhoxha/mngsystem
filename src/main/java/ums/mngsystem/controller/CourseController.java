package ums.mngsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ums.mngsystem.entities.Course;
import ums.mngsystem.entities.Faculty;
import ums.mngsystem.service.CourseService;

@RestController
@RequestMapping(name = "/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(name = "/save")
    public String saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return "Course " + course.getName() + " saved successfully";

    }

    @PutMapping(value = "/delete")
    public String deleteCourse(@RequestParam Integer courseId) {
        try {
            courseService.deleteCourse(courseId);
            return "course deleted successfully";
        }
        catch (Exception e) {
            return "Error";
        }
    }
    @PutMapping(value = "/update")
    public String updateCourse(@PathVariable Integer courseId, Course updatedCourse){

        courseService.updateCourse(courseId, updatedCourse);
        return "Course with "+ updatedCourse.getName()+ " is updated successfully";
    }
}