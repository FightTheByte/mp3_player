package org.example;
import org.example.player.AudioInterface;
import org.example.songs.Song;
import org.example.playlist.Playlist;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Playlist playlist = new Playlist("my playlist");
        playlist.addSong(new Song("alienboy.mp3", "alienboy"));
        playlist.addSong(new Song("cowboys.mp3", "cowboys"));
        playlist.addSong(new Song("missyou.mp3", "missyou"));

        System.out.println(playlist.getSong(0).getName());
        AudioInterface play = AudioInterface.getInstance();
        play.playSong("alienboy.mp3");
        TimeUnit.SECONDS.sleep(2);
        play.playSong("cowboys.mp3");
    }
}