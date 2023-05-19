package ums.mngsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ums.mngsystem.entities.Roles;
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
