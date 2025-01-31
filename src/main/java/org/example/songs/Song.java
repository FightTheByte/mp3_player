package org.example.songs;

import java.io.InputStream;

public class Song {

    private final InputStream songStream;

    private final String name;
    public Song(String location, String name){
        this.name = name;

        this.songStream = getClass().getClassLoader().getResourceAsStream(location);
    }

    public String getName(){
        return this.name;
    }

    public InputStream getSongStream(){
        return this.songStream;
    }
}
