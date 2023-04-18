package com.birdgang.user.stats.Controllers;

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

import com.birdgang.user.stats.Models.Stats;
import com.birdgang.user.stats.Models.StatsRepository;
import com.birdgang.user.user.Models.User;
import com.birdgang.user.user.Models.UserRepository;

@RestController
@RequestMapping("/api/v1/stats/")
public class StatsController {

    @Autowired
    private StatsRepository statsRepository;

    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<Stats> list() {
        List<Stats> stats = new ArrayList<>();
        return stats;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Stats stats){
    }

    @GetMapping("/{id}")
    public Stats get(@PathVariable("id") long id){
        return new Stats();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Stats> getAllStats() {
        return statsRepository.findAll();
    }

    @PostMapping(path="/add/{birdsSeen}/{squirrelsSeen}/{birdsIdentified}/{birdsUnidentified}")
    public @ResponseBody String addNewUser(@PathVariable("birdsSeen") int birdsSeen,
    @PathVariable("birdsSeen") int squirrelsSeen,@PathVariable("birdsIdentified") int birdsIdentified,
    @PathVariable("birdsUnidentified") int birdsUnidentified){
        Stats n = new Stats();
        n.setBirdsSeen(birdsSeen);
        n.setSquirrelsSeen(squirrelsSeen);
        n.setBirdsIdentified(birdsIdentified);
        n.setBirdsUnidentified(birdsUnidentified);
        return "Saved Birdfeeder";
        
    }
}

