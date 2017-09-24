package com.example.kimgo.kimgouweleeuw_pset4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Context context;
    DBHelper helper;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the databasehelper
        context = this;
        helper = new DBHelper(context);

        // Create a new contact to store in the database
        contact = new Contact("Mama", "0647788330");
    }
}
