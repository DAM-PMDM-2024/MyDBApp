package com.example.mydatabaseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context myContext;
    private static final String DATABASE_NAME = "MyLibrary.db";
    private static final String TABLE_NAME = "Books";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "title TEXT NOT NULL,"+
                "author TEXT NOT NULL,"+
                "pages INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    //CREATE
    public void createBook(Book book){
        //Obtain book values
        String titleNewBook = book.get_title();
        String authorNewBook = book.get_author();
        int pagesNewBook = book.get_pages();

        //Generate contentvalues to insert data
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",titleNewBook);
        contentValues.put("pages",pagesNewBook);
        contentValues.put("author",authorNewBook);

        //Access to the DB in write mode
        SQLiteDatabase database = this.getWritableDatabase();

        //Try to insert the book
        try{
            long result = database.insert(TABLE_NAME,null,contentValues);
            if(result != -1){
                //OK
                Toast.makeText(myContext,"Book inserted was success!",Toast.LENGTH_LONG).show();
            }
            else{
                //BAD
                Toast.makeText(myContext,"Error while inserting the book",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex){
            //Exception
            Toast.makeText(myContext,"Error while inserting the book" + ex.toString(),Toast.LENGTH_LONG).show();
        }
    }

    //READ
    public ArrayList<Book> getBooks(){
        ArrayList<Book> allBooks = new ArrayList<Book>();
        //Query for obtaining all the books
        String query = "SELECT id, title, author, pages FROM " + TABLE_NAME;
        //Access the database in readable mode
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor result = database.rawQuery(query,null);

        while(result.moveToNext()){
            allBooks.add(new Book(result.getInt(0),
                            result.getString(1),
                            result.getString(2),
                            result.getInt(3)));
        }
        result.close();
        return  allBooks;
    }

    //DELETE
    public void deleteBook(String bookDBID) {
        SQLiteDatabase database = this.getWritableDatabase();
        int result = database.delete(TABLE_NAME,"id = ?", new String[]{bookDBID});
        if(result != 0){
            //Borrado
            Toast.makeText(myContext,"Book deleted",Toast.LENGTH_LONG).show();
        }
        else{
            //No borrado
            Toast.makeText(myContext,"Error on deleting book",Toast.LENGTH_LONG).show();
        }
    }

    //UPDATE


}
