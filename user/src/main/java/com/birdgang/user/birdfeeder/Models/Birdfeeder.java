package com.birdgang.user.birdfeeder.Models;


import com.birdgang.user.user.Models.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Birdfeeder {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer birdfeederID;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "birdfeederUserID", referencedColumnName = "userID")
  private User user;

  private String birdfeederSettings;


  public User getFKUser(){
    return user;
  }

  public void setFKUser(User userID){
    this.user = userID;
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