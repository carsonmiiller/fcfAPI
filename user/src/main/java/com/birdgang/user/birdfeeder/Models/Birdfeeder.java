package com.birdgang.user.birdfeeder.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ForeignKey;

@Entity // This tells Hibernate to make a table out of this class
public class Birdfeeder {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer birdfeederID;
  //@ForeignKey
  //private Integer userID;
  private String birdfeederSettings;

  
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