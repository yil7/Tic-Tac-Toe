package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class RankActivity extends AppCompatActivity {
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        image = findViewById(R.id.imageView);
        String url = "https://i.etsystatic.com/14605261/r/il/ec414d/1879954105/il_570xN.1879954105_dbna.jpg";
        Picasso.get().load(url).resize(1000,1500).into(image);
    }
}
