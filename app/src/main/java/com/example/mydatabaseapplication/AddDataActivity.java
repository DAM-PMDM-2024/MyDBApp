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

                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                contentValues.put("title",tituloInsertado);
                contentValues.put("author",autorInsertado);
                contentValues.put("pages",Integer.valueOf(paginasInsertadas));

                long insertResult = database.insert("Books",null,contentValues);

                if(insertResult == -1){
                    //Error
                    Toast.makeText(AddDataActivity.this,"Error al insertar el libro",Toast.LENGTH_LONG).show();
                }
                else{
                    //OK
                    Toast.makeText(AddDataActivity.this,"Libro insertado correctamente",Toast.LENGTH_LONG).show();
                }
/*
                String print = String.format("El libro introducido es %s del autor %s con %s páginas",
                        tituloInsertado,autorInsertado,paginasInsertadas);
                System.out.println(print);

                String print2 = MessageFormat.format("El libro introducido es {0} del autor {1} con {2} páginas.",
                        tituloInsertado,autorInsertado,paginasInsertadas);
                System.out.println(print2);
*/
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