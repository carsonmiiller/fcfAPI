package com.birdgang.user.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.persistence.Entity;

/**
 * This class maps to the User table in the Five Course Feeder database.
 * It is used to carry out the basic CRUD operations on a single instance
 * from the table.
 * @author:  Carson Miller
 * @version: 2023.03.28
 */
@Entity
public class User {

    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    

    /**
     * This is an empty constructor for the User class.
     * It is used to create an instance of the class without initializing
     * any of the instance variables. This constructor is called when creating
     * a new instance of the class to be inserted into the User table.
     * @return an instance of the User class
     */
    public User(){
        // validate existense of dbcxnmaker

        // creating an empty User instance

        // return User
    }

    /**
     * This is a constructor for the User class.
     * It is used to create an instance of the class and initialize
     * the instance variables with the values that correspond to the
     * instance in the User table with the given primary key value.
     * @param userID - the primary key value of the record in the User table
     * @return an instance of the User class
     */
    public User(int userID){
        // validate existense of dbcxnmaker

        // use primary key to access existing row in table 
        
        // use to set values of instance vars

        // return User
    }

    // Getters and Setters
    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Long getUserID(){
        return this.userID;
    } 
    
    public void setUserID(Long userID){
        this.userID = userID;
    } 
    /**
     * This method executes an INSERT INTO statement on the This table.
     * It creates a new record in the table.
     * It could be called by the save() method.
     */
    private void create(){
        // use JDBC Connection to initialize Statement object
        
        // execute INSERT INTO query on Statement object using instance variables
    }
    
    /**
     * This method executes a SELECT statement on the This table.
     * It selects all columns for a particular primary key value.
     * It is called by the load() method.
     * @param:  userID - the primary key value of the record to be read
     */
    private void read(Long userID){
        // use JDBC Connection to initialize Statement object
        
        // execute SELECT query on Statement object using primary key variable
        
        // set instance variables to results from query
    }
    
    /**
     * This method executes an UPDATE statement on the User table.
     * It updates the table with the values of the instance variables
     * in this User object.
     * It could be called by the save() method.
     */
    private void update(){
        // use JDBC Connection to initialize Statement object
        
        // execute UPDATE query on Statement object using instance variables
    }
    
    /**
     * This method executes a DELETE statement on the User table.
     * It deletes the record for this instance of the User class.
     * It is called by the remove() method.
     */
    private void delete(){
        // use JDBC Connection to initialize Statement object
        
        // execute DELETE query on Statement object using instance's primary key
    }

    /**
     * This method calls create() if the userID does not exist in the User table or
     * update() if the userID exists in the User table
     */
    public void save(){
        // validate existence of primary key in table

        /*
         * MySQL Statement to execute:
         * SELECT EXISTS(SELECT * from Users WHERE User_id=userID);
         * 
         * Store result in boolean variable called exists
         */

        // if exists:
            update();
        // else:
            create();
    }

    /**
     * This method calls read() to "pick up" the record for a particular primary key value.
     * @param:  userID - the primary key value of the record to be read
     */
    public void load(Long userID){
        // call read() to pick up the record corresponding to the userID
        read(this.userID);
    }

    /**
     * This method calls delete() to remove this instance of the User
     * class from the User table.
     */
    public void remove(){
        // call delete() to remove record for this instance of the table
        delete();
    }
}
