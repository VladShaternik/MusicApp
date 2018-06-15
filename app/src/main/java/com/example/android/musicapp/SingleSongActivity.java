package com.example.android.musicapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleSongActivity extends AppCompatActivity {

    boolean isMuted = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_song);

        // Show the date of the song
        TextView songName = findViewById(R.id.song_name);
        songName.setText(getIntent().getStringExtra("song_name"));

        ImageView songImage = findViewById(R.id.song_image);
        songImage.setImageResource(getIntent().getIntExtra("song_image_res", R.drawable.no_image));

        TextView songAuthors = findViewById(R.id.song_authors);
        songAuthors.setText(getIntent().getStringExtra("song_authors"));

        // Make volume button work (with changing icon and actual sound muting and back)
        final ImageView volumeButton = findViewById(R.id.volume_button);
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        assert audioManager != null;
        if (audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) == 0) {
            volumeButton.setImageResource(R.drawable.volume_mute_button);
        } else {
            volumeButton.setImageResource(R.drawable.volume_button);
        }
        volumeButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (isMuted) {
                    volumeButton.setImageResource(R.drawable.volume_mute_button);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                    isMuted = !isMuted;
                } else {
                    volumeButton.setImageResource(R.drawable.volume_button);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0);
                    isMuted = !isMuted;
                }
            }
        });

        // Add song to the list of added songs
        ImageView addSongButton = findViewById(R.id.add_song_button);
        addSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Song songToAdd = new Song(getIntent().getStringExtra("song_name"),
                        getIntent().getStringExtra("song_authors"),
                        getIntent().getIntExtra("song_image_res", R.drawable.no_image));

                AddedSongsList addedSongsList = new AddedSongsList();

                // Show toast
                if (addedSongsList.AddSong(songToAdd)) {
                    Toast songAddedToast = Toast.makeText(getApplicationContext(), "Added to the library!", Toast.LENGTH_SHORT);
                    songAddedToast.show();
                } else {
                    Toast songAddedToast = Toast.makeText(getApplicationContext(), "Can\'t add, already in the library", Toast.LENGTH_SHORT);
                    songAddedToast.show();
                }
            }
        });
    }
}
