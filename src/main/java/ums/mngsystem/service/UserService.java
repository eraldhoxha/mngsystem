package ums.mngsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ums.mngsystem.entities.Faculty;
import ums.mngsystem.entities.Students;
import ums.mngsystem.entities.User;
import ums.mngsystem.enums.Roles;
import ums.mngsystem.repository.FacultyRepository;
import ums.mngsystem.repository.StudentsRepository;
import ums.mngsystem.repository.UserRepository;

import javax.management.relation.Role;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);

    }

    public void assignRole(User user, Roles role) {
        user.setRoles(role);
        userRepository.save(user);

    }
}
