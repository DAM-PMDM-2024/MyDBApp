package com.example.mydatabaseapplication;

public class Book {

    private int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public int get_pages() {
        return _pages;
    }

    public void set_pages(int _pages) {
        this._pages = _pages;
    }

    private String _title;

    private String _author;

    private int _pages;

    //Constructor for adding a new Book
    public Book(String _title, String _author, int _pages){
        this._title = _title;
        this._author = _author;
        this._pages = _pages;
    }

    //Constructor for retrieving all the books
    public Book(int _id, String _title, String _author, int _pages){
        this._id = _id;
        this._title = _title;
        this._author = _author;
        this._pages = _pages;
    }



}
