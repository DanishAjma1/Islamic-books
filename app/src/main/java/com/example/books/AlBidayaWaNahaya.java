package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mymobileapp.R;

public class AlBidayaWaNahaya extends AppCompatActivity {

    private ConstraintLayout first;
    private ConstraintLayout second;
    private ConstraintLayout third;
    private ConstraintLayout fourth;
    private ConstraintLayout fifth;
    private ConstraintLayout sixth;
    private ConstraintLayout seventh;
    private ConstraintLayout eighth;
    private ConstraintLayout ninth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_al_bidaya_wa_nahaya);

        first = findViewById(R.id.first_chap);
        second = findViewById(R.id.second_chap);
        third = findViewById(R.id.third_chap);
        fourth = findViewById(R.id.fourth_chap);
        fifth = findViewById(R.id.fifth_chap);
        sixth = findViewById(R.id.sixth_chap);
        seventh = findViewById(R.id.seventh_chap);
        eighth = findViewById(R.id.eighth_chap);
        ninth = findViewById(R.id.ninth_chap);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","1");
                startActivity(i);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","2");
                startActivity(i);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","3");
                startActivity(i);
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","4");
                startActivity(i);
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","5");
                startActivity(i);
            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","6");
                startActivity(i);
            }
        });
        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","7");
                startActivity(i);
            }
        });
        eighth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","8");
                startActivity(i);
            }
        });
        ninth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","9");
                startActivity(i);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}