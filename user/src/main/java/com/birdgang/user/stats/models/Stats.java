package com.birdgang.user.stats.models;

import com.birdgang.user.birdfeeder.Models.Birdfeeder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Stats {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer userID;
  @OneToOne(mappedBy = "user")
  private Birdfeeder birdfeeder;
  private String username;
  private String password;
  private String firstName;
  private String lastName;

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFisrtName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}