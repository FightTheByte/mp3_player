package org.example.player;

import org.example.player.Gui;
import org.example.player.AudioInterface;

public class Mp3Player implements PlayerActions {
    private static Mp3Player mp3Player;

    private Mp3Player(){

    }

    public Mp3Player getInstance(){
        if(mp3Player == null){
            mp3Player = new Mp3Player();
        }
        return mp3Player;
    }

    @Override
    public void play(int position){

    }

    @Override
    public void pause(){

    }
    @Override
    public void next(int position){

    }
    @Override
    public void previous(int position){

    }
    @Override
    public void delete(int position){

    }
    @Override
    public void addSong(String name, String songLocation){

    }

    @Override
    public void removeSong(int songPosition){

    };
}
