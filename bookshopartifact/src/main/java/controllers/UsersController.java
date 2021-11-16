package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import models.Users;
import models.CreditCard;
import services.UserService;

@RestController
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/users/create")
    public Users create(@RequestBody Users user) {
        Users.saveUser(user);
        return user;
    }

    @GetMapping("/users/find/{userEmail}")
    public Users getUser(@PathVariable String userEmail) {
        return Users.getUser(userEmail);
    }

    @GetMapping("/users/update")
    public Users getUser(@RequestBody Users user) {
        return Users.updateUser(user);
    }

    @GetMapping("/users/creditcard/add/{userId}")
    public CreditCard getUser(@PathVariable int userId, @RequestBody CreditCard creditCard) {
        Users.addCreditCardToUser(userId , creditCard);
        creditCard.user_id = userId;
        return creditCard;
    }

    @GetMapping("/users/creditcard/list/{user_email}")
    public ArrayList<CreditCard> getCreditCardsByUserEmail(@PathVariable String user_email) {
        return Users.getCreditCards(user_email);
   }
    
}
