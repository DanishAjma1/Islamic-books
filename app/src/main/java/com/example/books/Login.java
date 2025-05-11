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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginButton;
    private FirebaseAuth mAuth;
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
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        if (Email.isEmpty()) {
            Toast.makeText(Login.this, "No email set", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Password.isEmpty()) {
            Toast.makeText(Login.this, "No password set", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Email.equals(intent.getStringExtra("email"))) {
            Toast.makeText(Login.this, Email+" "+intent.getStringExtra("email"), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Password.equals(intent.getStringExtra("password"))) {
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

        email= findViewById(R.id.emailinput);
        password = findViewById(R.id.passwordinput);
        loginButton = findViewById(R.id.loginButton);

        navigateToSignUp();
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                if (Email.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(Login.this, "No email set", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(Login.this, task -> {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this, Dashboard.class));
                                    finish();
                                } else {
                                    Toast.makeText(Login.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(Login.this, Dashboard.class));
            finish();
        }
    }
}