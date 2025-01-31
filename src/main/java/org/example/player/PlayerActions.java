package org.example.player;

import java.io.InputStream;

public interface PlayerActions {
    public void play(int songPosition); //play song

    public void pause(); //pause song

    public void next(int songPosition); //skip forward to next track

    public void previous(int songPosition); //skip backwards to next track

    public void delete(int songPosition); //delete from playlist

    public void addSong(String name, String songLocation); //add a song to list

    public void removeSong(int songPosition); //remove song from list
}
