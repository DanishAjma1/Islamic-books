package com.example.books;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymobileapp.R;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginButton;
    public void navigateToSignUp() {
        TextView tvSignup = findViewById(R.id.signupText);
        SpannableString ss = new SpannableString("Don't have any account? Sign Up");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 25, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // "Sign up" is from index 25 to 32
        tvSignup.setText(ss);
        tvSignup.setMovementMethod(LinkMovementMethod.getInstance());
        tvSignup.setHighlightColor(Color.TRANSPARENT);
    }

    private boolean validation() {
        Intent intent = getIntent();
        if (email == null) {
            Toast.makeText(Login.this, "No email set", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password == null) {
            Toast.makeText(Login.this, "No password set", Toast.LENGTH_SHORT).show();
            return false;
        }
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        if (!emailString.equals(intent.getStringExtra("email"))) {
            Toast.makeText(Login.this, "Invalid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!passwordString.equals(intent.getStringExtra("password"))) {
            Toast.makeText(Login.this, "Invalid password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        navigateToSignUp();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validate = validation();
                if(validate){
                    Intent i = new Intent(Login.this, Dashboard.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
}