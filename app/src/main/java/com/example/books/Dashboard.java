package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mymobileapp.R;

public class Dashboard extends AppCompatActivity {

    private final ImageButton button1= findViewById(R.id.imageButton1);
    private ImageButton button2= findViewById(R.id.imageButton2);
    private ImageButton button3= findViewById(R.id.imageButton3);
    private ImageButton button4= findViewById(R.id.imageButton4);
    private ImageButton button5= findViewById(R.id.imageButton5);
    private ImageButton button6= findViewById(R.id.imageButton6);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Dashboard.this,AlBidayaWaNahaya.class);
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