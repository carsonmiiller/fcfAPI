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

import com.birdgang.user.birdfeeder.Models.Birdfeeder;
import com.birdgang.user.birdfeeder.Models.BirdfeederRepository;
import com.birdgang.user.user.Models.User;

@RestController
@RequestMapping("/api/v1/stats/")
public class StatsController {

    @Autowired
    private StatsRepository statsRepository;

    @GetMapping
    public @ResponseBody List<Stats> list() {
        List<stats> statss = new ArrayList<>();
        return statss;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody stats stats){
    }

    @GetMapping("/{id}")
    public stats get(@PathVariable("id") long id){
        return new stats();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<stats> getAllstatss() {
        return statsRepository.findAll();
    }

    @PostMapping(path="/add/{fkUser}/{statsSettings}")
    public @ResponseBody String addNewUser(@PathVariable("fkUser") User fkUser,
     @PathVariable("statsSettings") String statsSettings){
        stats n = new stats();
        n.setFKUser(fkUser);
        n.setstatsSettings(statsSettings);
        statsRepository.save(n);
        return "Saved stats";
    }
}

