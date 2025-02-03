package org.example.playlist;
import java.util.ArrayList;
import java.util.List;

import org.example.songs.Song;
import org.example.playlist.Position;
public class Playlist{
    private static List<Song> playlist;
    private String playlist_name;
    private static Position position;
    public Playlist(String name){
        this.playlist_name = name;
        playlist = new ArrayList<>();
        position = new Position();
    }

    public synchronized void addSong(Song song){
        playlist.add(song);
    }

    public String getPlaylistName(){
        return this.playlist_name;
    }

    public List<Song> getPlaylist(){
        return playlist;
    }

    public Song getSong(int position){
        return playlist.get(position);
    }

    public synchronized void removeSong(int position){
        playlist.remove(position);
    }

    public void increasePosition(){
        position.increasePosition(playlist.size());
    }

    public void decreasePosition(){
        position.decreasePosition(playlist.size());
    }
}
