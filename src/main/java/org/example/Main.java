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
        AudioInterface player = AudioInterface.getInstance();
        player.playSong(playlist.getSong(0).getSongStream(), false);
        TimeUnit.SECONDS.sleep(2);
        player.playSong(playlist.getSong(1).getSongStream(), true);
    }
}