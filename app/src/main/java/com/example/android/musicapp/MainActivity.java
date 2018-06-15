package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> addedSongs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> recommendedSongs = new ArrayList<>();

        // Add songs
        recommendedSongs.add(new Song(getString(R.string.song_name_0), getString(R.string.author_0), R.drawable.kids_see_ghosts));
        recommendedSongs.add(new Song(getString(R.string.song_name_1), getString(R.string.author_1), R.drawable.good_man));
        recommendedSongs.add(new Song(getString(R.string.song_name_2), getString(R.string.author_2), R.drawable.lost_and_found));
        recommendedSongs.add(new Song(getString(R.string.song_name_3), getString(R.string.author_3), R.drawable.mountain));
        recommendedSongs.add(new Song(getString(R.string.song_name_4), getString(R.string.author_4), R.drawable.so_sad_so_sexy));
        recommendedSongs.add(new Song(getString(R.string.song_name_5), getString(R.string.author_5), R.drawable.superfly));

        // Show songs
        SongListAdapter songAdapter = new SongListAdapter(this, recommendedSongs);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(songAdapter);

        // Play songs on click of one of the songs
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new intent to open the {@link SingleSongActivity}
                Intent singleSongIntent = new Intent(MainActivity.this, SingleSongActivity.class);

                Song clickedSong = (Song)parent.getItemAtPosition(position);

                singleSongIntent.putExtra("song_name", clickedSong.GetSongName());
                singleSongIntent.putExtra("song_authors", clickedSong.GetSongDescription());
                singleSongIntent.putExtra("song_image_res", clickedSong.GetSongImage());
                singleSongIntent.putExtra("song_position", position);

                // Start the new activity
                startActivity(singleSongIntent);
            }
        });

        Button buttonAddedSongs = findViewById(R.id.button_added_songs);

        // Go to the added songs activity (library) on click of button
        buttonAddedSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link AddedSongsActivity}
                Intent addedSongsIntent = new Intent(MainActivity.this, AddedSongsActivity.class);

                addedSongsIntent.putIntegerArrayListExtra("added_songs_positions", addedSongs);

                // Start the new activity
                startActivity(addedSongsIntent);
            }
        });
    }
}
