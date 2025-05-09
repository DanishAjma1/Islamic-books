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

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlBidayaWaNahaya.this,md_book_reading.class);
                i.putExtra("chap_number","1");
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