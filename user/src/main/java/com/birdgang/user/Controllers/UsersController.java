package com.birdgang.user.Controllers;

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

import com.birdgang.user.Models.User;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @GetMapping
    public List<User> list() {
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
}

