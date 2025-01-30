package org.example.playlist;
import java.util.ArrayList;
import org.example.songs.Song;
import org.example.playlist.Position;
public class Playlist extends Position{
    private ArrayList<Song> playlist = new ArrayList<>();

    private String playlist_name;
    public Playlist(String name){
        this.playlist_name = name;
    }

    public synchronized void addSong(Song song){
        this.playlist.add(song);
    }

    public String getPlaylistName(){
        return this.playlist_name;
    }

    public ArrayList<Song> getPlaylist(){
        return this.playlist;
    }

    public Song getSong(int position){
        return this.playlist.get(position);
    }

    public synchronized void removeSong(int position){
        this.playlist.remove(position);
    }

    @Override
    public void increasePosition(){
        int maxPosition = this.playlist.size() - 1;
        int currentPosition = getPosition();

        if(currentPosition + 1 > maxPosition){
            setPosition(0);
        } else {
            setPosition(currentPosition + 1);
        }
    }

    @Override
    public void decreasePosition(){
        int minPosition = 0;
        int currentPosition = getPosition();

        if(currentPosition - 1 < minPosition){
            setPosition(this.playlist.size() - 1);
        } else {
            setPosition(currentPosition - 1);
        }
    }
}
