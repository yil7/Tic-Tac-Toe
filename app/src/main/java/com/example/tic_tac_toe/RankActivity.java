package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class RankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        String url = "http://i.imgur.com/DvpvklR.png";
        ImageView image = findViewById(R.id.imageView);
        Picasso.get().load(url).resize(50, 50)
                .centerCrop().into(image);

    }
}
