package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    protected String randValue(int Max){
        int Min = 1;
        // valeur aleatoire comprise entre le Min et le Max
        int randValue = Min + (int)(Math.random() * ((Max - Min) + 1));
        return String.valueOf(randValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.button_roll);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        EditText editText = (EditText) findViewById(R.id.nombre_faces_du_de);


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int max = 6;
                 //la fonction randValue() est definie plus haut!
                if(!editText.getText().toString().equals("")){
                    max = Integer.parseInt(editText.getText().toString());
                }
                textView.setText(randValue(max));
                textView1.setText(randValue(max));
            }
        });


    }
}