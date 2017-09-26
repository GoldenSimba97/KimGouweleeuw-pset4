package com.example.kimgo.kimgouweleeuw_pset4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    DBHelper helper;
    Contact toDo;
    ArrayList<Contact> todoList;
    ListView lvItems;
    EditText newTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newTodo = (EditText) findViewById(R.id.editTodo);
        newTodo.setHint("Add new to-do");

        // Create the databasehelper
        context = this;
        helper = new DBHelper(context);

        // Create a new to-do item to store in the database
//        toDo = new Contact("Shoppen");

        // Create a to-do item in our database
//        helper.create(toDo);

        // Delete the contact from the database
//        helper.delete(toDo);

        // Ask for a list of all to-dos
        todoList = helper.read();

        lvItems = (ListView) findViewById(R.id.listViewID);

        TodoAdapter todoAdapter = new TodoAdapter(this, todoList);
//        lvItems = (ListView) findViewById(R.id.listViewID);
        assert lvItems != null;
        lvItems.setAdapter(todoAdapter);

//        makeTodoAdapter();



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

    public class TodoAdapter extends ArrayAdapter<Contact> {
        public TodoAdapter(Context context, ArrayList<Contact> todoList) {
            super(context, 0, todoList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Contact title = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_todo, parent, false);
            }
            // Lookup view for data population
            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            // Populate the data into the template view using the data object
            tvTitle.setText(title.title);
            // Return the completed view to render on screen
            return convertView;
        }
    }

//    public void makeTodoAdapter() {
//        ArrayAdapter arrayAdapter = new ArrayAdapter<>
//                (this, android.R.layout.simple_list_item_1, todoList);
//        lvItems = (ListView) findViewById(R.id.listViewID);
//        assert lvItems != null;
//        lvItems.setAdapter(arrayAdapter);
//        TodoAdapter todoAdapter = new TodoAdapter(this, todoList);
//        lvItems = (ListView) findViewById(R.id.listViewID);
//        assert lvItems != null;
//        lvItems.setAdapter(todoAdapter);
//    }

}
