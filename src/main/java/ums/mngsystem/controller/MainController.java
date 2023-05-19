package ums.mngsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homepage")
public class MainController {

    @PostMapping("/name")
    public String homepage(@RequestBody String name){
        return name;
    }
}
