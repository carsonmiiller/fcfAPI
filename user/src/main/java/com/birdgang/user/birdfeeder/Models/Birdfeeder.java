package com.birdgang.user.birdfeeder.Models;

import java.util.Optional;

import com.birdgang.user.user.Models.User;
import com.birdgang.user.user.Models.UserRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ForeignKey;

@Entity // This tells Hibernate to make a table out of this class
public class Birdfeeder {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer birdfeederID;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "birdfeederUserID", referencedColumnName = "userID")
  private User fkUser;

  private String birdfeederSettings;


  public User getFKUser(){
    return fkUser;
  }

  public void setFKUser(Optional<User> optional){
    this.fkUser = optional;
  }

  public Integer getBirdfeederID() {
    return birdfeederID;
  }

  public void setBirdfeederID(Integer birdfeederID) {
    this.birdfeederID = birdfeederID;
  }

  public String getBirdfeederSettings(){
    return birdfeederSettings;
  }

  public void setBirdfeederSettings(String birdfeederSettings){
    this.birdfeederSettings = birdfeederSettings;
  }
}