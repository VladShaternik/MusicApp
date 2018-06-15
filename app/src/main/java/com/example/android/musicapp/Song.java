package com.example.android.musicapp;

/**
 * CLASS - represents song with the main attributes: name, authors, and image resource id of the song
 */
public class Song {
    private String mSongName;
    private String mSongAuthors;
    private int mSongImage;

    Song(String songName, String songAuthors, int songImage) {
        mSongName = songName;
        mSongAuthors = songAuthors;
        mSongImage = songImage;
    }

    /**
     * METHOD - returns song name
     *
     * @return - song name
     */
    public String GetSongName() {
        return mSongName;
    }

    /**
     * METHOD - returns song description (authors)
     *
     * @return - song description (authors)
     */
    public String GetSongDescription() {
        return mSongAuthors;
    }

    /**
     * METHOD - returns song image resource id
     *
     * @return - song image resource id
     */
    public int GetSongImage() {
        return mSongImage;
    }
}
