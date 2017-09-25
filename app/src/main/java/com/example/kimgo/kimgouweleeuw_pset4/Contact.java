package com.example.kimgo.kimgouweleeuw_pset4;

import java.io.Serializable;

/**
 * Created by kimgo on 24-9-2017.
 */

public class Contact implements Serializable {
    private String title;
    private int completed;
    private int _id;

    // Constructor for to-do from database
    public Contact(String todoTitle) {
        title = todoTitle;
        completed = 0;
    }

    public Contact(String todoTitle, int todoCompleted, int todoID) {
        title = todoTitle;
        completed = todoCompleted;
        _id = todoID;
    }

    // Get the to-do title
    public String getTitle() { return title; }

    // Get if the to-do is completed
    public int getCompleted() { return completed; }

    // Get the to-do id
    public int getID() { return _id; }

    // Set the title
    public void setTitle(String newTitle) { title = newTitle; }

    // Set if to-do is completed
    public void setCompleted() { completed = 1; }

    // Set the to-do id
    public void setID(int newID) { _id = newID; }


//    private String name;
//    private String phoneNumber;
//    private int _id;
//
//    // Constructor for contacts from database
//    public Contact(String contactName, String contactNumber) {
//        name = contactName;
//        phoneNumber = contactNumber;
//    }
//
//    public Contact(String contactName, String contactNumber, int contactID) {
//        name = contactName;
//        phoneNumber = contactNumber;
//        _id = contactID;
//    }
//
//    // Get the contact number
//    public String getNumber() { return phoneNumber; }
//
//    // Get the contact name
//    public String getName() { return name; }
//
//    // Set the contact number
//    public void setNumber(String newNumber) { phoneNumber = newNumber; }
//
//    // Set the contact name
//    public void setName(String newName) { name = newName; }
//
//    // Get the contact id
//    public int getID() { return _id; }
//
//    // Set the contact id
//    public void setID(int newID) { _id = newID; }

}
