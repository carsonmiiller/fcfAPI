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

    ///////////////////////////////////////////////////////////////////////////////
    //                                                                           //
    //  WOULD RATHER PASS PARAMETERS IN THE BODY OF THE REQUEST THAN IN THE URL  //
    //                                                                           //
    ///////////////////////////////////////////////////////////////////////////////
    /**
     * This method is used to register a user
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @return HttpStatus.OK if the user was successfully registered,
     *          HttpStatus.CONFLICT if the username already exists
     */
    @PostMapping(path="/register")
    public @ResponseStatus String register(@RequestBody String username, String password, String firstName, String lastName){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        if(userRepository.findByUsername(username) != null)
            return HttpStatus.CONFLICT.toString();
        else {
            userRepository.save(user);
            return HttpStatus.OK.toString();
        }   
    }

    /**
     * This method is used to login a user
     * @param username
     * @param password
     * @return HttpStatus.OK if the user exists and the password is correct,
     *          HttpStatus.NOT_FOUND if the user does not exist,
     *          HttpStatus.UNAUTHORIZED if the password is incorrect
     */
    @PostMapping(path="/login")
    public @ResponseStatus String login(@RequestBody String username, String password){
        // HOW DO I CHECK IF THE USER EXISTS IN THE DATABASE?
        // HOW DO I CHECK IF THE PASSWORD IS CORRECT?
        // IDEALLY, THERE WOULD BE A METHOD IN THE REPOSITORY THAT WOULD DO THIS FOR ME
        // BUT I DON'T KNOW HOW TO DO THAT
        if(userRepository.findByUsername(username) == null)
            return HttpStatus.NOT_FOUND.toString();
        else if(userRepository.findByUsername(username).getPassword() != password)
            return HttpStatus.UNAUTHORIZED.toString();
        else
            return HttpStatus.OK.toString();
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
        return userRepository.findAll();
    }

    // DON'T LIKE PASSING THE PARAMETERS IN THE URL
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

