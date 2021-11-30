package com.example.td4;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());

        Button buttonOk = findViewById(R.id.btn_ok);
        TextView textViewName = findViewById(R.id.textView_name);

        // get the application context and its associated data
        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String login = app.getLogin();
        textViewName.setText(login);

        buttonOk.setOnClickListener(view -> {
            // go back a newsActivity
            finish();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
