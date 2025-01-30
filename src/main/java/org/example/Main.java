package org.example;
import org.example.songs.Song;
import org.example.playlist.Playlist;
public class Main {
    public static void main(String[] args) {

        Playlist playlist = new Playlist("my playlist");
        playlist.addSong(new Song("../../../resources/alienboy.mp3", "alienboy"));
        playlist.addSong(new Song("../../../resources/cowboys.mp3", "cowboys"));
        playlist.addSong(new Song("../../../resources/missyou.mp3", "missyou"));

        System.out.println(playlist.getSong(0).getName());
    }
}