package ums.mngsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ums.mngsystem.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
