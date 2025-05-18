package com.example.books;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileapp.R;

import java.util.ArrayList;
import java.util.List;

public class AllBooks extends AppCompatActivity implements OnBookClickListener {

    RecyclerView recyclerView;
    BookAdapter adapter;
    List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books); // must contain RecyclerView

        recyclerView = findViewById(R.id.bookRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookList = new ArrayList<>();
        // Example books
        bookList.add(new Book("Al-Bidaya Wan-Nihaya", "Ibn Kathir", R.drawable._5st_century_vintage_book));
        bookList.add(new Book("Tafsir Ibn Kathir", "Ibn Kathir", R.drawable._5st_century_vintage_book));
        bookList.add(new Book("Riyadh-us-Saliheen", "Imam Nawawi", R.drawable._5st_century_vintage_book));

        adapter = new BookAdapter(this, bookList, this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onBookClick(Book book) {
        Toast.makeText(this, "Clicked: " + book.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
