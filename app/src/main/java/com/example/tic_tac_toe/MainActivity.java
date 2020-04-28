package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button begin;
    private Button rank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        begin = (Button) findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                beginGame();
            }
        });

        rank = (Button) findViewById(R.id.rank);
        rank.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkRank();
            }
        });

    }
    public static final String EXTRA_MESSAGE1 = "com.example.tic-tac-toe.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.tic-tac-toe.MESSAGE2";
    public void beginGame() {
        Intent intent = new Intent(this, GameActivity.class);
        EditText p1 = (EditText) findViewById(R.id.editText);
        EditText p2 = (EditText) findViewById(R.id.editText2);
        String player1 = p1.getText().toString();
        String player2 = p2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, player1);
        intent.putExtra(EXTRA_MESSAGE2, player2);
        startActivity(intent);
    }

    public void checkRank() {
        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }
}
