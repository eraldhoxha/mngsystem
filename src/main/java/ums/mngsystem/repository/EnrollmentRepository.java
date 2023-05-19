package ums.mngsystem.repository;

import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ums.mngsystem.entities.Enrollment;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    @Override
    Optional<Enrollment> findById(Integer enrollmentId);
}
