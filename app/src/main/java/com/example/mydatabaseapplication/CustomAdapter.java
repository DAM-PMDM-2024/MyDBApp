package com.example.mydatabaseapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyBookView> {
    @NonNull
    @Override
    public CustomAdapter.MyBookView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyBookView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
