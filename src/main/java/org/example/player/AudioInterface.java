package org.example.player;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class AudioInterface {
    private static AudioInterface audio_interface;
    private static Thread playerThread;
    private static Player runningPlayer;
    private AudioInterface(){}

    public static AudioInterface getInstance(){
        if(audio_interface == null){
            audio_interface = new AudioInterface();
        }
        return audio_interface;
    }

    public void playSong(InputStream inputStream){

        try{
            if(runningPlayer != null){
                runningPlayer.close();
                playerThread.interrupt();
            }
            runningPlayer = new Player(inputStream);
            playerThread = new Thread(() ->{
                try{
                    runningPlayer.play();
                } catch(Exception e){
                    System.out.println(e);
                }
            });
            playerThread.start();

        } catch(Exception e){
            System.out.println(e);
        }
    }

}
