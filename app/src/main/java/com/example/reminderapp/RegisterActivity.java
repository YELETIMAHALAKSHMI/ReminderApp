package com.example.reminderapp;

import static com.example.reminderapp.R.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    TextView btn;
    Button btnRegister ;
    private EditText inputUsername, inputPassword, inputEmail, inputConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            btn = findViewById(id.alreadyhaveaccount);
            btnRegister = findViewById(id.btnRegister);
            inputUsername = findViewById(id.inputUsername);
            inputEmail = findViewById(id.inputEmail);
            inputPassword = findViewById(id.inputPassword);
            inputConfirmPassword = findViewById(id.inputPassword);
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkCredentials();
                }
            });
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            });
        }
        private void checkCredentials(){
            String username = inputUsername.getText().toString();
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();
            String confirmpassword = inputConfirmPassword.getText().toString();
            if(username.isEmpty() || username.length()<7){
                showError(inputUsername, "Your username is not valid...!!!");
            }
            else if(email.isEmpty() || !email.contains("@")){
                showError(inputEmail, "Email is not valid");
            }
            else if(password.isEmpty() || password.length()<7){
                showError(inputPassword, "Password must be 7 characters...");
            }
            else if(confirmpassword.isEmpty() || !confirmpassword.equals(password)){
                showError(inputConfirmPassword, "Password does not match...");
            }
            else{
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        }
        private void showError(EditText input, String s){
            input.setError(s);
            input.requestFocus();
        }
}