package com.example.reminderapp;

import static com.example.reminderapp.R.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView btn;
    EditText inputEmail, inputPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn = findViewById(R.id.textviewsignup);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                checkCredentials();
            }
        });
        btn.setOnClickListener((v) -> {
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        });
    }
    private void checkCredentials(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        if(email.isEmpty() || !email.contains("@")){
            showError(inputEmail, "Email is not valid");
        }
        else if(password.isEmpty() || password.length()<7){
            showError(inputPassword, "Password must be 7 characters...");
        }
        else{
            startActivity(new Intent(LoginActivity.this,AddingPage.class));
        }
    }
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
}
