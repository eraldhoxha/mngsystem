package ums.mngsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ums.mngsystem.entities.User;
import ums.mngsystem.enums.Roles;
import ums.mngsystem.service.UserService;

@RestController
@RequestMapping(name = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "User "+ user.getUsername() + " saved successfully";

    }
    @PutMapping("/setRole")
    public String setRole(@RequestParam User user, @RequestParam Roles role){
        user.setRoles(role);
        userService.saveUser(user);

        return "User with the role "+ user.getRoles() + " saved successfully";

    }
}
