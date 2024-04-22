package com.example.mydatabaseapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;

    FloatingActionButton addNewBookButton;

    RecyclerView recyclerView;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewBookButton = findViewById(R.id.addNewBook);
        addNewBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addActivityIntent = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(addActivityIntent);
            }
        });

        dbHelper = new DatabaseHelper(MainActivity.this);

        //Getting all the books
        ArrayList<Book> allBooks = dbHelper.getBooks();

        recyclerView = findViewById(R.id.recyclerView);
        customAdapter = new CustomAdapter(MainActivity.this,allBooks);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }
}