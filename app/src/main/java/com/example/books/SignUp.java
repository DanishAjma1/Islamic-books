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

public class SignUp extends AppCompatActivity {

    private Button signUpButton;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    public boolean validation() {
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String ConfirmPassword = confirmPassword.getText().toString();

        if (Email == null) {
            Toast.makeText(SignUp.this, "No email set", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Password == null && ConfirmPassword == null) {
            Toast.makeText(SignUp.this, "No passwords set", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Password.length() < 8) {
            Toast.makeText(SignUp.this, "Password length should be greater than 8", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Password != ConfirmPassword) {
            Toast.makeText(SignUp.this, password.getText().toString() + " " + confirmPassword.getText().toString(), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void navigateToLogin() {
        TextView tvSignIn = findViewById(R.id.signInText);
        if (tvSignIn == null) {
            Toast.makeText(this, "TextView is null!", Toast.LENGTH_LONG).show();
        }else{
            SpannableString ss = new SpannableString("Already have account? SignIn");

            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View v) {
                    Intent i =new Intent(SignUp.this, Login.class);
                    startActivity(i);
                }
            };

            ss.setSpan(clickableSpan, 22, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // "Sign up"

            tvSignIn.setText(ss);
            tvSignIn.setMovementMethod(LinkMovementMethod.getInstance());
            tvSignIn.setHighlightColor(Color.TRANSPARENT);}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        navigateToLogin();

        signUpButton=findViewById(R.id.SignUpButton);
        email = findViewById(R.id.emailinput);
        password = findViewById(R.id.passwordinput);
        confirmPassword = findViewById(R.id.confirmpassword);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validate = validation();
                if(validate){
                    Toast.makeText(SignUp.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUp.this, Login.class);
                    i.putExtra("email", email.getText().toString());
                    i.putExtra("password", password.getText().toString());
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}