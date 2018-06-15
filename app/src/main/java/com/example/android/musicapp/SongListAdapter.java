package com.example.android.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * CLASS - custom ArrayAdapter
 */
public class SongListAdapter extends ArrayAdapter<Song> {

    SongListAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView currentSongName = listItemView.findViewById(R.id.song_name);
        assert currentSong != null;
        currentSongName.setText(currentSong.GetSongName());

        ImageView currentSongImage = listItemView.findViewById(R.id.song_image);
        currentSongImage.setImageResource(currentSong.GetSongImage());

        TextView currentSongDescription = listItemView.findViewById(R.id.song_authors);
        currentSongDescription.setText(currentSong.GetSongDescription());

        return listItemView;
    }
}
