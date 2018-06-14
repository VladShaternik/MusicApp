package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> recommendedSongs = new ArrayList<>();

        recommendedSongs.add(new Song("KIDS SEE GHOSTS", "Kanye West, Kid Cudi", R.drawable.kids_see_ghosts));
        recommendedSongs.add(new Song("GOOD MAN", "Ne-Yo", R.drawable.good_man));
        recommendedSongs.add(new Song("Lost & Found", "Jorjia Smith", R.drawable.lost_and_found));
        recommendedSongs.add(new Song("The Mountain", "Dierks Bentley", R.drawable.mountain));
        recommendedSongs.add(new Song("so sad so sexy", "Lykke Li", R.drawable.so_sad_so_sexy));
        recommendedSongs.add(new Song("SUPERFLY", "Future, 21 Savage, Lil Wayne", R.drawable.superfly));

        SongListAdapter songAdapter = new SongListAdapter(this, recommendedSongs);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new intent to open the {@link SingleSongActivity}
                Intent singleSongIntent = new Intent(MainActivity.this, SingleSongActivity.class);

                Song clickedSong = (Song)parent.getItemAtPosition(position);

                singleSongIntent.putExtra("song_name", clickedSong.GetSongName());
                singleSongIntent.putExtra("song_authors", clickedSong.GetSongDescription());
                singleSongIntent.putExtra("song_image_res", clickedSong.GetSongImage());

                // Start the new activity
                startActivity(singleSongIntent);

            }
        });

        Button buttonAddedSongs = findViewById(R.id.button_added_songs);

        buttonAddedSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link AddedSongsActivity}
                Intent addedSongsIntent = new Intent(MainActivity.this, AddedSongsActivity.class);

                // Start the new activity
                startActivity(addedSongsIntent);
            }
        });
    }
}
