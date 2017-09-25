package com.example.kimgo.kimgouweleeuw_pset4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    DBHelper helper;
    Contact toDo;
    ArrayList<Contact> todoList;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the databasehelper
        context = this;
        helper = new DBHelper(context);

        // Create a new to-do item to store in the database
        toDo = new Contact("Shoppen");

        // Create a to-do item in our database
        helper.create(toDo);

        // Ask for a list of all to-dos
        todoList = helper.read();

        lvItems = (ListView) findViewById(R.id.listViewID);

        makeTodoAdapter();



//        // Create a new contact to store in the database
//        contact = new Contact("Mama", "0647788330");
//
//        // Create a contact in our database
//        helper.create(contact);
//
//        // Change the number and then update
//        contact.setNumber("0647788321");
//        helper.update(contact);
//
//        // Delete the contact from the database
//        helper.delete(contact);
//
//        // Ask for a list of all contacts
//        contactList = helper.read();
    }

    public void makeTodoAdapter() {
        ArrayAdapter arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, todoList);
        lvItems = (ListView) findViewById(R.id.listViewID);
        assert lvItems != null;
        lvItems.setAdapter(arrayAdapter);
    }
}
