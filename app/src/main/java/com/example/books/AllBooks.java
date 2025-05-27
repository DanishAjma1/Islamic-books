package com.example.books;

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
        // Example books
        bookList.add(new Book("Al-Bidaya Wan-Nihaya Volume 1 ", "Ibn Kathir", R.drawable._5st_century_vintage_book));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya Volume 2", "Ibn Kathir", R.drawable._5st_century_vintage_book));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya Volume 3", "Imam Nawawi", R.drawable._5st_century_vintage_book));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya Volume 4", "Imam Nawawi", R.drawable._5st_century_vintage_book));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya Volume 5", "Imam Nawawi", R.drawable._5st_century_vintage_book));
        bookList.add(new Book("Al-Bidaya Wan-Nihaya Volume 6", "Imam Nawawi", R.drawable._5st_century_vintage_book));

        adapter = new BookAdapter(this, bookList, this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onBookClick(Book book) {
        String title = book.getTitle();

        if (title.equals("Al-Bidaya Wan-Nihaya Volume 1")) {
            // Do something specific for this book
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 1", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, AlBidayaActivity.class));

        } else if (title.equals("Al-Bidaya Wan-Nihaya Volume 2")) {
            // Do something for Tafsir Ibn Kathir
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 2", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, TafsirIbnKathirActivity.class));

        } else if (title.equals("Al-Bidaya Wan-Nihaya Volume 3")) {
            // Do something for Riyadh-us-Saliheen
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 3", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, RiyadhUsSaliheenActivity.class));
        } else if (title.equals("Al-Bidaya Wan-Nihaya Volume 4")) {
            // Do something for Riyadh-us-Saliheen
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 4", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, RiyadhUsSaliheenActivity.class));
        } else if (title.equals("Al-Bidaya Wan-Nihaya Volume 5")) {
            // Do something for Riyadh-us-Saliheen
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 5", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, RiyadhUsSaliheenActivity.class));
        } else if (title.equals("Al-Bidaya Wan-Nihaya Volume 6")) {
            // Do something for Riyadh-us-Saliheen
            Toast.makeText(this, "Opening Al-Bidaya Wan-Nihaya Volume 6", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, RiyadhUsSaliheenActivity.class));
        }
    }

}
