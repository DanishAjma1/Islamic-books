package com.example.books;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileapp.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;
    private Context context;
    private OnBookClickListener listener;

    // Modified constructor to receive the listener
    public BookAdapter(Context context, List<Book> bookList, OnBookClickListener listener) {
        this.context = context;
        this.bookList = bookList;
        this.listener = listener;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageButton bookIcon;
        TextView bookTitle, bookAuthor;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookIcon = itemView.findViewById(R.id.book_icon);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
        }

        public void bind(Book book, OnBookClickListener listener) {
            itemView.setOnClickListener(v -> listener.onBookClick(book));
        }
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());
        holder.bookIcon.setImageResource(book.getIconResId());

        // Call bind to attach listener
        holder.bind(book, listener);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
