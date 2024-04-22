package com.example.mydatabaseapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyBookView> {

    private Context context;
    private ArrayList<Book> books;

    CustomAdapter(Context context, ArrayList<Book> books){
        this.context = context;
        this.books = books;
    }
    @NonNull
    @Override
    public CustomAdapter.MyBookView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_book, parent, false);
        return new MyBookView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyBookView holder, int position) {
        holder.bookId.setText(String.valueOf(position));
        holder.bookTitle.setText(String.valueOf(books.get(position).get_title()));
        holder.bookAuthor.setText(String.valueOf(books.get(position).get_author()));
        holder.bookPages.setText(String.valueOf(books.get(position).get_pages()));

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class MyBookView extends RecyclerView.ViewHolder {
        LinearLayout mainLayout;
        TextView bookId;
        TextView bookTitle;
        TextView bookAuthor;
        TextView bookPages;

        public MyBookView(@NonNull View itemView) {
            super(itemView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            bookId = itemView.findViewById(R.id.bookId);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookTitle = itemView.findViewById(R.id.bookTitle);
            bookPages = itemView.findViewById(R.id.bookPages);
        }
    }
}
