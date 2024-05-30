package com.nzr.centralapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;


public class LoginActivity extends AppCompatActivity {

    TextInputEditText editUsername, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
    }
public void onButtonLoginClick (View view) {
    String username = editUsername.getText().toString();
    String password = editPassword.getText().toString();

        if(password.equals("123")){
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("USERNAME", username);
            mainIntent.putExtra("IS_LOGGED_IN", true);
            startActivity(mainIntent);
        } else{
            Toast.makeText(this, "Kombinasi username dan password salah",Toast.LENGTH_SHORT).show();
        }
    }
    public void onForgotPasswordClicked(View view) {
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:085722666427"));
        startActivity(callIntent);
    }
}