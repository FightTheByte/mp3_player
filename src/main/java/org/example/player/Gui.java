package org.example.player;
import javax.swing.*;
public class Gui {
    //private final JFrame guiWindow;

    private static Gui gui;
    private Gui(){}

    public static Gui getInstance(){
        if(gui == null){
            gui = new Gui();
        }
        return gui;
    }

}
