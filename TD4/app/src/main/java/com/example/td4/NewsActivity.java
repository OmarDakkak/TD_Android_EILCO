package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        Intent intent = getIntent();
        String login = "NOM";
        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
        }


        Button buttonDetails = findViewById(R.id.button_details);
        Button buttonLogout = findViewById(R.id.button_logout);
        Button buttonAbout = findViewById(R.id.button_about);
        TextView textViewNom = findViewById(R.id.textView_nom);

        textViewNom.setText("Bonjour " + login);

        buttonDetails.setOnClickListener(view -> {
            //go details activity
            Intent intent_details = new Intent(NewsActivity.this, DetailsActivity.class);
            startActivity(intent_details);
        });

        buttonLogout.setOnClickListener(view -> {
            // return to LoginActivity
            Intent intent_login = new Intent(NewsActivity.this, LoginActivity.class);
            startActivity(intent_login);
            finish();
        });


        buttonAbout.setOnClickListener(view -> {
            String url = "https://fr.news.yahoo.com/";
            Intent intent_news = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent_news);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}