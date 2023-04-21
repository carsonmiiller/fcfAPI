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

    /**
     * This method is used to register a user
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @return HttpStatus.OK if the user was successfully registered,
     *          HttpStatus.CONFLICT if the username already exists
     */
    @GetMapping(path="/register/{username}/{password}/{firstName}/{lastName}")
    public @ResponseBody String register(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        Iterable<User> userRepo = getAllUsers();
        for (User user : userRepo) {
            if (user.getUsername().equals(username))
                return "This username already exists!";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        userRepository.save(newUser);
        return "Successfully registered!";
    }

    /**
     * This method is used to login a user
     * @param username
     * @param password
     * @return HttpStatus.OK if the user exists and the password is correct,
     *          HttpStatus.NOT_FOUND if the user does not exist,
     *          HttpStatus.UNAUTHORIZED if the password is incorrect
     */
    @GetMapping(path="/login/{username}/{password}")
    public @ResponseBody String login(@PathVariable String username, @PathVariable String password){
        Iterable<User> userRepo = getAllUsers();
        for (User user : userRepo) {
            if(user.getUsername().equals(username)){
                if(user.getPassword().equals(password))
                    return "success";
                else
                    return "wrong_password";
            }
        }
        return "userDNE";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") long id){
        return new User();
    }

    public UserRepository getRepo(){
        return this.userRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}

