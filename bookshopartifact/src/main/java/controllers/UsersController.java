package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    
    @GetMapping("/create")
    public boolean createUser() {
        return false; 
    }

    @GetMapping("/find")
    public boolean findUser() {
        return false; 
    }

    
}
