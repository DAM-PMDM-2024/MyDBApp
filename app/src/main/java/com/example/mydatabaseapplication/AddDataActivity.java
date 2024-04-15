package com.example.mydatabaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.MessageFormat;

public class AddDataActivity extends AppCompatActivity {

    //Defino objetos que voy a usar
    EditText titulo;
    EditText autor;
    EditText paginas;
    Button addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        //Asigno los objetos creados a los elementos de la vista
        titulo = findViewById(R.id.tituloText);
        autor = findViewById(R.id.autorText);
        paginas = findViewById(R.id.paginasText);
        addBook = findViewById(R.id.addButton);

        //Limpiamos los campos
        detectAndCleanFields();

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cogemos los datos que ha insertado el usuario
                String tituloInsertado = titulo.getText().toString().trim();
                String autorInsertado = autor.getText().toString().trim();
                String paginasInsertadas = paginas.getText().toString().trim();

                //Obtengo la base de datos
                DatabaseHelper dbHelper = new DatabaseHelper(AddDataActivity.this);

                Book newBook = new Book(tituloInsertado, autorInsertado, Integer.parseInt(paginasInsertadas));

                dbHelper.createBook(newBook);

            }
        });

    }

    private void detectAndCleanFields() {
        titulo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                titulo.setText("");
                return false;
            }
        });

        autor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                autor.setText("");
                return false;
            }
        });

        paginas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                paginas.setText("");
                return false;
            }
        });
    }
}