package org.example.player;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileFormat;

import javax.sound.sampled.*;


public class AudioInterface implements LineListener {
    private static AudioInterface audio_interface;
    private static AudioInputStream audioInputStream;

    private static Clip audioclip;
    boolean isCompleted;
    private int pausedOnFrame = 0;
    private static Thread playerThread;

    private AudioInterface(){}

    public static AudioInterface getInstance(){
        if(audio_interface == null){
            audio_interface = new AudioInterface();
        }
        return audio_interface;
    }

    @Override
    public void update(LineEvent event){
        if(LineEvent.Type.START == event.getType()){
            System.out.println("Playing");
        } else if(LineEvent.Type.STOP == event.getType()){
            System.out.println("Stopping");
        }
    }

    public void playSong(InputStream inputStream, boolean newSong){

        try{
            if(newSong){
                audioInputStream = AudioSystem.getAudioInputStream(inputStream);
                AudioFormat audioFormat = MpegAudioFileReader
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
                audioclip = (Clip) AudioSystem.getLine(info);
                audioclip.addLineListener(this);
                audioclip.open(audioInputStream);

            }
            if(playerThread != null){
                if (!playerThread.isInterrupted() && newSong) {
                    playerThread.interrupt();
                    System.out.println("new song");
                }
            }


            playerThread = new Thread(() ->{
                try{
                    audioclip.start();
                } catch(Exception e){
                    System.out.println(e);
                }
            });
            playerThread.start();

        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void pause() {
        if (!playerThread.isInterrupted()) {
                audioclip.stop();
                playerThread.interrupt();
        }
    }

}
