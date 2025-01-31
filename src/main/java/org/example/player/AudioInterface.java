package org.example.player;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;


public class AudioInterface {
    private static AudioInterface audio_interface;

    private static int pausedOnFrame = 0;
    private static Thread playerThread;
    private static AdvancedPlayer runningPlayer;
    private AudioInterface(){}

    public static AudioInterface getInstance(){
        if(audio_interface == null){
            audio_interface = new AudioInterface();
        }
        return audio_interface;
    }

    public void playSong(InputStream inputStream, boolean newSong){

        try{
            if(runningPlayer != null){
                runningPlayer.close();
                playerThread.interrupt();
            }
            if(newSong){
                pausedOnFrame = 0;
            }
            runningPlayer = new AdvancedPlayer(inputStream);
            playerThread = new Thread(() ->{
                try{
                    runningPlayer.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent evt) {
                            super.playbackFinished(evt);
                            pausedOnFrame = evt.getFrame();
                        }
                    });
                    runningPlayer.play(pausedOnFrame, Integer.MAX_VALUE);
                } catch(Exception e){
                    System.out.println(e);
                }
            });
            playerThread.start();

        } catch(JavaLayerException e){
            System.out.println(e);
        }
    }



}
