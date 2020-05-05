package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];

    private boolean player1Turn = true;

    private int roundCount;

    private int player1score;

    private int player2score;

    private String player1;

    private String player2;

    private TextView textViewPlayer1;

    private TextView textViewPlayer2;

    private int imagePlayer1;

    private int imagePlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        player1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        player2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        textViewPlayer1 = findViewById(R.id.textView4);
        textViewPlayer2 = findViewById(R.id.textView5);
        textViewPlayer1.setText(player1);
        textViewPlayer2.setText(player2);

        imagePlayer1 = (int)(Math.random() * ((3) + 1));
        imagePlayer2 = (int)(Math.random() * ((3) + 1));

        String[] images = new String[10];
        images[1] = "https://i.imgur.com/EkkDR.jpg";
        images[2] = "https://i.imgur.com/MBwoG60.png";
        images[3] = "https://i.imgur.com/Ln3bk3h.jpg";

        ImageView imagefor1 = findViewById(R.id.image1);
        Picasso.get().load("https://i.imgur.com/EkkDR.jpg").into(imagefor1);

        ImageView imagefor2 = findViewById(R.id.image2);
        Picasso.get().load(images[imagePlayer2]).into(imagefor2);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button buttonRest = findViewById(R.id.button26);
        buttonRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Win();
            } else {
                player2Win();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals("")
                    && board[i][0].equals(board[i][1])
                    && board[i][1].equals(board[i][2])) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!board[0][i].equals("")
                    && board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])) {
                return true;
            }
        }

        if (!board[0][0].equals("")
                && board[0][0].equals(board[1][1])
                && board[0][0].equals(board[2][2])) {
            return true;
        }

        if (!board[0][2].equals("")
                && board[0][2].equals(board[1][1])
                && board[0][2].equals(board[2][0])) {
            return true;
        }

        return false;
    }

    private void player1Win() {
        player1score++;
        Toast.makeText(this,player1 + " wins!", Toast.LENGTH_SHORT).show();
        updateScoreText();
        resetBoard();
    }

    private void player2Win() {
        player2score++;
        Toast.makeText(this,player2 + " wins!", Toast.LENGTH_SHORT).show();
        updateScoreText();
        resetBoard();

    }

    private void draw() {
        Toast.makeText(this,"Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updateScoreText() {
        textViewPlayer1.setText(player1 + "   "+player1score);
        textViewPlayer2.setText(player2 + "   "+player2score);
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                buttons[i][j].setText("");
            }
        }

        roundCount = 0;
        player1Turn = true;
    }

}
