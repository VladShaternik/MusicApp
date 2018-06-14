package com.example.android.musicapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleSongActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_song);

        TextView songName = findViewById(R.id.song_name);
        songName.setText(getIntent().getStringExtra("song_name"));

        ImageView songImage = findViewById(R.id.song_image);
        songImage.setImageResource(getIntent().getIntExtra("song_image_res", R.drawable.no_image));

        TextView songAuthors = findViewById(R.id.song_authors);
        songAuthors.setText(getIntent().getStringExtra("song_authors"));
    }
}
