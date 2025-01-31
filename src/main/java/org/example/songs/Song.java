package org.example.songs;

import java.io.InputStream;

public class Song {

    private final String songLocation;

    private final String name;
    public Song(String location, String name){
        this.name = name;

        this.songLocation = location;
    }

    public String getName(){
        return this.name;
    }

    public InputStream getSongLocation(){
        return getClass().getClassLoader().getResourceAsStream(this.songLocation);
    }
}
