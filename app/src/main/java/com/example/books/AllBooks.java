package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
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
        bookList.add(new Book("Al-Bidaya Wan-Nihaya :Volume 1", "Ibn Kathir", R.drawable.albidaya));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya :Volume 2", "Ibn Kathir", R.drawable.albidaya));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya :Volume 3", "Ibn Kathir", R.drawable.albidaya));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya :Volume 4", "Ibn Kathir", R.drawable.albidaya));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya :Volume 5", "Ibn Kathir", R.drawable.albidaya));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya :Volume 6", "Ibn Kathir", R.drawable.albidaya));

        adapter = new BookAdapter(this, bookList, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onBookClick(Book book) {
        String title = book.getTitle();

        if (title.equals("Al-Bidaya Wan-Nihaya :Volume 1")) {
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 1", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, AlBidayaWaNahayaVolume1.class));

        } else if (title.equals("Al-Bidaya Wan-Nihaya :Volume 2")) {
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 2", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, AlBidayaWaNahayaVolume2.class));

        } else if (title.equals("Al-Bidaya Wan-Nihaya :Volume 3")) {
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 3", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, AlBidayaWaNahayaVolume3.class));

        } else if (title.equals("Al-Bidaya Wan-Nihaya :Volume 4")) {
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 4", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, AlBidayaWaNahayaVolume4.class));

        } else if (title.equals("Al-Bidaya Wan-Nihaya :Volume 5")) {
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 5", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, AlBidayaWaNahayaVolume5.class));

        } else if (title.equals("Al-Bidaya Wan-Nihaya :Volume 6")) {
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 6", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, AlBidayaWaNahayaVolume6.class));
        }
    }
}
