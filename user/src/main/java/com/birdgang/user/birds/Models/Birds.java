package com.birdgang.user.birds.Models;

import java.sql.Date;
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
public class Birds {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer birdsID;

  //@OneToOne(cascade = CascadeType.ALL)
  //@JoinColumn(name = "birdfeederUserID", referencedColumnName = "userID")
  //private Optional<User> fkUser;

  private String birdUnderstood;
  private String birdName;
  private String birdTimeSeenID;
  private Integer birdUserID;
  private Integer birdBirdfeederID;

  public Integer getBirdBirdfeederID() {
    return birdBirdfeederID;
  }

  public void setBirdBirdfeederID(Integer birdBirdfeederID) {
    this.birdBirdfeederID = birdBirdfeederID;
  }

  public Integer getBirdUserID() {
    return birdUserID;
  }

  public void setBirdUserID(Integer birdUserID) {
    this.birdUserID = birdUserID;
  }

  public String getBirdUnderstood(){
    return birdUnderstood;
  }

  public void setBirdUnderstood(String birdUnderstood){
    this.birdUnderstood = birdUnderstood;
  }

  public String getBirdName(){
    return birdName;
  }

  public void setBirdName(String birdName){
    this.birdName = birdName;
  }

  public String getBirdTimeSeenID(){
    return birdTimeSeenID;
  }

  public void setBirdTimeSeenID(String birdTimeSeenID){
    this.birdTimeSeenID = birdTimeSeenID;
  }
}