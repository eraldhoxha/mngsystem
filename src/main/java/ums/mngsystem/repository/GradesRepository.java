package ums.mngsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ums.mngsystem.entities.Grades;
@Repository
public interface GradesRepository extends JpaRepository<Grades, Integer> {
}
