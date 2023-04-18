package com.birdgang.user.birdfeeder.Controllers;
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

import com.birdgang.user.birdfeeder.Models.Birdfeeder;
import com.birdgang.user.birdfeeder.Models.BirdfeederRepository;
import com.birdgang.user.user.Models.User;
import com.birdgang.user.user.Models.UserRepository;

@RestController
@RequestMapping("/api/v1/birdfeeder/")
public class BirdfeederController {

    @Autowired
    private BirdfeederRepository birdfeederRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<Birdfeeder> list() {
        List<Birdfeeder> birdfeeders = new ArrayList<>();
        return birdfeeders;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Birdfeeder birdfeeder){
    }

    @GetMapping("/{id}")
    public Birdfeeder get(@PathVariable("id") long id){
        return new Birdfeeder();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Birdfeeder> getAllbirdfeeders() {
        return birdfeederRepository.findAll();
    }

    @PostMapping(path="/add/{fkUser}/{birdfeederSettings}")
    public @ResponseBody String addNewUser( @PathVariable("fkUser") Integer fkUser,
                                            @PathVariable("birdfeederSettings") String birdfeederSettings){
        User u = userRepository.findById(fkUser).orElse(new User());
        Birdfeeder n = new Birdfeeder();
        n.setBirdfeederSettings(birdfeederSettings);
        n.setFKUser(u);
        birdfeederRepository.save(n);
        return "Saved Birdfeeder";
    }
}

