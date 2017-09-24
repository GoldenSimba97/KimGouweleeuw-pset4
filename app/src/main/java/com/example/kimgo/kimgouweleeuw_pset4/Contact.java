package com.example.kimgo.kimgouweleeuw_pset4;

import java.io.Serializable;

/**
 * Created by kimgo on 24-9-2017.
 */

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private int _id;

    // Constructor for contacts from database
    public Contact(String contactName, String contactNumber) {
        name = contactName;
        phoneNumber = contactNumber;
    }

    public Contact(String contactName, String contactNumber, int contactID) {
        name = contactName;
        phoneNumber = contactNumber;
        _id = contactID;
    }

    // Get the contact number
    public String getNumber() { return phoneNumber; }

    // Get the contact name
    public String getName() { return name; }

    // Set the contact number
    public void setNumber(String newNumber) { phoneNumber = newNumber; }

    // Set the contact name
    public void setName(String newName) { name = newName; }

    // Get the contact id
    public int getID() { return _id; }

    // Set the contact id
    public void setID(int newID) { _id = newID; }

}
