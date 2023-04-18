package com.birdgang.user.stats.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Stats {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer statsID;
  //@OneToOne(mappedBy = "user")
  //private Birdfeeder birdfeeder;
  private int birdsSeen;
  private int squirrelsSeen;
  private int birdsIdentified;
  private int birdsUnidendtified;
  //private int statsUserID;

  public Integer getStatsID() {
    return statsID;
  }

  public void setStatsID(Integer statsID) {
    this.statsID = statsID;
  }

  public int getSquirrelsSeen() {
    return squirrelsSeen;
  }

  public void setSquirrelsSeen(int squirrelsSeen) {
    this.squirrelsSeen = squirrelsSeen;
  }

  public int getBirdsIdentified() {
    return birdsIdentified;
  }

  public void setBirdsIdentified(int birdsIdentified) {
    this.birdsIdentified = birdsIdentified;
  }

  public int getBirdsSeen() {
    return birdsSeen;
  }

  public void setBirdsSeen(int birdsSeen) {
    this.birdsSeen = birdsSeen;
  }

  public int getBirdsUnidentified() {
    return birdsUnidendtified;
  }

  public void setBirdsUnidentified(int birdsUnidentified) {
    this.birdsUnidendtified = birdsUnidentified;
  }
}