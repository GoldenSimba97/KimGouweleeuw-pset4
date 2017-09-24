package com.example.kimgo.kimgouweleeuw_pset4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    DBHelper helper;
    Contact contact;
    ArrayList<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the databasehelper
        context = this;
        helper = new DBHelper(context);

        // Create a new contact to store in the database
        contact = new Contact("Mama", "0647788330");

        // Create a contact in our database
        helper.create(contact);

        // Change the number and then update
        contact.setNumber("0647788321");
        helper.update(contact);

        // Delete the contact from the database
        helper.delete(contact);

        // Ask for a list of all contacts
        contactList = helper.read();
    }
}
