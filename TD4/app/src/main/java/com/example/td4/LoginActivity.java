package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());
        Button buttonLogin = findViewById(R.id.btn_login);
        EditText editTextNom = findViewById(R.id.nom_editText);
        NewsListApplication app = (NewsListApplication) getApplicationContext();
        buttonLogin.setOnClickListener(view -> {
            // go a news activity
            Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
            intent.putExtra("login", editTextNom.getText().toString());
            app.setLogin(editTextNom.getText().toString());
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}