package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddedSongsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_songs);

        final ArrayList<Song> addedSongs = new AddedSongsList().GetSongArrayList();

        // Show list of added songs
        SongListAdapter songAdapter = new SongListAdapter(this, addedSongs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(songAdapter);

        // Play clicked music
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new intent to open the {@link SingleSongActivity}
                Intent singleSongIntent = new Intent(AddedSongsActivity.this, SingleSongActivity.class);

                Song clickedSong = (Song) parent.getItemAtPosition(position);

                singleSongIntent.putExtra("song_name", clickedSong.GetSongName());
                singleSongIntent.putExtra("song_authors", clickedSong.GetSongDescription());
                singleSongIntent.putExtra("song_image_res", clickedSong.GetSongImage());
                singleSongIntent.putExtra("song_position", position);

                // Start the new activity
                startActivity(singleSongIntent);
            }
        });

        // Remove song on long click
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                addedSongs.remove(position);

                // Refresh activity
                recreate();
                return false;
            }
        });
    }
}
