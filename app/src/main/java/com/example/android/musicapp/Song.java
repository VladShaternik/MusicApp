package com.example.android.musicapp;

import android.media.Image;

public class Song {
    private String mSongName;
    private String mSongAuthors;
    private int mSongImage;

    public Song(String songName, String songDescription, int songImage) {
        mSongName = songName;
        mSongAuthors = songDescription;
        mSongImage = songImage;
    }

    public String GetSongName() {
        return mSongName;
    }

    public String GetSongDescription() {
        return mSongAuthors;
    }

    public int GetSongImage() {
        return mSongImage;
    }
}
