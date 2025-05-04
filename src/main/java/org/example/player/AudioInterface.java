package org.example.player;
import java.io.InputStream;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

import javax.sound.sampled.*;

// Implement the Audio interface, with play pause methods, takes an InputStream
public class AudioInterface implements LineListener {
    private static AudioInterface audio_interface;
    private static AudioInputStream audioInputStream;

    private static Clip audioclip;
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
                AudioFormat audioFormat = audioInputStream.getFormat();
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
