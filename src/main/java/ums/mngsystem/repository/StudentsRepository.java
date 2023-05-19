package ums.mngsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ums.mngsystem.entities.Students;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
    @Override
    Optional<Students> findById(Integer studentId);
    Optional<Students> findByEmail(String email);
}
