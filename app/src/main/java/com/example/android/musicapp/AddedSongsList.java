package com.example.android.musicapp;

import java.util.ArrayList;

/**
 * CLASS - represents list of added songs. Also, helps to transfer data between activities
 */
public class AddedSongsList {
    // ArrayList of added songs
    private static ArrayList<Song> songArrayList = new ArrayList<>();

    AddedSongsList() {
    }

    /**
     * METHOD - add song to the list if it is not in the list already
     *
     * @param song - song to add
     * @return - whether the song adding process was successful
     */
    public boolean AddSong(Song song) {
        boolean isAddingSuccessful = false;

        // Search for the same song in the list
        int i = 0;
        while (i != songArrayList.size() && songArrayList.get(i).GetSongImage() != song.GetSongImage()) {
            i++;
        }

        // If the song is not in the list then add it
        if (i == songArrayList.size()) {
            songArrayList.add(song);
            isAddingSuccessful = true;
        }

        return isAddingSuccessful;
    }

    /**
     * METHOD - get the ArrayList with added songs
     *
     * @return - ArrayList with added songs
     */
    public ArrayList<Song> GetSongArrayList() {
        return songArrayList;
    }
}
