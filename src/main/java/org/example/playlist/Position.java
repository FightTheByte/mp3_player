package org.example.playlist;

public class Position {
    private int position = 0;

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void increasePosition(int size){
        int maxPosition = size - 1;
        int currentPosition = getPosition();

        if(currentPosition + 1 > maxPosition){
            setPosition(0);
        } else {
            setPosition(currentPosition + 1);
        }
    }

    public void decreasePosition(int size){
        int minPosition = 0;
        int currentPosition = getPosition();

        if(currentPosition - 1 < minPosition){
            setPosition(size - 1);
        } else {
            setPosition(currentPosition - 1);
        }
    }
}
