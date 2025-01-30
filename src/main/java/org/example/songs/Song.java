package org.example.songs;

public class Song {

    private final String location;

    private final String name;
    public Song(String location, String name){
        this.name = name;

        this.location = location;
    }

    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;
    }
}
