package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String player1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String player2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        TextView textView1 = findViewById(R.id.textView4);
        TextView textView2 = findViewById(R.id.textView5);
        textView1.setText(player1);
        textView2.setText(player2);
    }
}
