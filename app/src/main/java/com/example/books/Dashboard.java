package com.example.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mymobileapp.R;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    private ImageButton button1;
//    private ImageButton button2= findViewById(R.id.imageButton2);
//    private ImageButton button3= findViewById(R.id.imageButton3);
//    private ImageButton button4= findViewById(R.id.imageButton4);
//    private ImageButton button5= findViewById(R.id.imageButton5);
//    private ImageButton button6= findViewById(R.id.imageButton6);
    private Button logoutBtn;
    private LinearLayout profileLayout;
    private ImageButton profileBtn;
    private LinearLayout dashboardLayout;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_dashboard);

        button1= findViewById(R.id.imageButton1);
        logoutBtn = findViewById(R.id.logoutBtn);
        profileLayout = findViewById(R.id.profile_layout);
        profileBtn = findViewById(R.id.profileBtn);
        dashboardLayout = findViewById(R.id.dashboard_layout);
        backBtn =findViewById(R.id.backBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i= new Intent(Dashboard.this,Login.class);
                startActivity(i);
                finish();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileLayout.setVisibility(View.GONE);
                dashboardLayout.setVisibility(View.VISIBLE);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardLayout.setVisibility(View.GONE);
                profileLayout.setVisibility(View.VISIBLE);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Dashboard.this,AlBidayaWaNahaya.class);
                startActivity(i);
            }
        });
    }
}