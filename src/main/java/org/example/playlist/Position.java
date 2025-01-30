package org.example.playlist;

public abstract class Position {
    private int position = 0;

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public abstract void increasePosition(); //increase current playlist position

    public abstract void decreasePosition(); //decrease current playlist position
}
