package com.birdgang.user.birds.Controllers;
import java.util.List;
import java.sql.Date;
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
import org.springframework.format.annotation.DateTimeFormat;

import com.birdgang.user.birdfeeder.Models.BirdfeederRepository;
import com.birdgang.user.birdfeeder.Models.Birdfeeder;
import com.birdgang.user.birds.Models.Birds;
import com.birdgang.user.birds.Models.BirdsRepository;
import com.birdgang.user.user.Models.User;
import com.birdgang.user.user.Models.UserRepository;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@RestController
@RequestMapping("/api/v1/birds/")
public class BirdsController {

    @Autowired
    private BirdsRepository birdsRepository;

    private BirdfeederRepository birdfeederRepository;
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<Birds> list() {
        List<Birds> birdfeeders = new ArrayList<>();
        return birdfeeders;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Birds birdfeeder){
    }

    @GetMapping("/{id}")
    public Birds get(@PathVariable("id") long id){
        return new Birds();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Birds> getAllbirdfeeders() {
        return birdsRepository.findAll();
    }

    @PostMapping(path="/add/{birdUnderstood}/{birdName}/{birdTimeSeenID}/{FKbirdUserID}/{FKbirdBirdfeederID}")
    public @ResponseBody String addNewUser(
                                            @PathVariable("birdUnderstood") String birdUnderstood,
                                            @PathVariable("birdName") String birdName,
                                            @PathVariable("birdTimeSeenID") String birdTimeSeenID,
                                            @PathVariable("FKbirdUserID") Integer FKbirdUserID,
                                            @PathVariable("FKbirdBirdfeederID") Integer FKbirdBirdfeederID){
 
        Birds n = new Birds();
        n.setBirdBirdfeederID(FKbirdBirdfeederID);
        n.setBirdUserID(FKbirdUserID);
        n.setBirdUnderstood(birdUnderstood);
        n.setBirdName(birdName);
        n.setBirdTimeSeenID(birdTimeSeenID);
        birdsRepository.save(n);
        return "Saved Birds";
    }
}
