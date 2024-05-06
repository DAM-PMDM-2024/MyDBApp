package com.example.mydatabaseapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateActivity extends AppCompatActivity {

    EditText bookAuthorField;
    EditText bookTitleField;
    EditText bookPagesField;

    Button updateBookButton;
    Button deleteBookButton;

    DatabaseHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bookTitleField = findViewById(R.id.editTitleText);
        bookAuthorField = findViewById(R.id.editAuthorText);
        bookPagesField = findViewById(R.id.editPagesText);

        updateBookButton = findViewById(R.id.updateBookButton);
        deleteBookButton = findViewById(R.id.deleteBookButton);

        //Obtengo los datos que me vienen de la pantalla principal
        String authorValue = getIntent().getStringExtra("author");
        String titleValue = getIntent().getStringExtra("title");
        String pagesValue = getIntent().getStringExtra("pages");
        String bookDBID = getIntent().getStringExtra("id");

        //Paso los valores a los campos de texto
        bookTitleField.setText(titleValue);
        bookAuthorField.setText(authorValue);
        bookPagesField.setText(pagesValue);

        myDBHelper = new DatabaseHelper(UpdateActivity.this);

        updateBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle = bookTitleField.getText().toString().trim();
                String newAuthor = bookAuthorField.getText().toString().trim();
                int newPages = Integer.valueOf(bookPagesField.getText().toString().trim());
                myDBHelper.updateBook(newTitle, newAuthor, newPages, bookDBID);
            }
        });

        deleteBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDBHelper.deleteBook(bookDBID);
            }
        });
    }
}