package com.birdgang.user.user.Controllers;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.birdgang.user.user.Models.User;
import com.birdgang.user.user.Models.UserRepository;

@RestController
@RequestMapping("/api/v1/users/")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<User> list() {
        List<User> users = new ArrayList<>();
        return users;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody User user){
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") long id){
        return new User();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path="/add/{username}/{password}/{firstName}/{lastName}")
    public @ResponseBody String addNewUser(@PathVariable("username") String username, @PathVariable("password") String password,
                                            @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        User n = new User();
        n.setUsername(username);
        n.setPassword(password);
        n.setFirstName(firstName);
        n.setLastName(lastName);
        userRepository.save(n);
        return "Saved";
    }
}

