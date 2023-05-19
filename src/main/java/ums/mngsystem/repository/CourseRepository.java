package ums.mngsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ums.mngsystem.entities.Course;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Override
    Optional<Course> findById(Integer courseId);

    Optional<Course> findByName(String name);
}
