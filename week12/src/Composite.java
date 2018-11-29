/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.media.AudioClip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Админ
 */
public class Composite implements Shape{
    int cycleCount = 1;
    double rate = 1;
    double volume = 50;
    int delay = 1;
    ArrayList<Shape> sounds = new ArrayList<>();

    public void add(Shape... s){
        sounds.addAll(Arrays.asList(s));
    }

    public void removeAll(){

        sounds.clear();
    }
    public void setCycleCount(int c){
        for(Shape sound:sounds){
            sound.setCycleCount(c);
        }
    }
    public void setRate(double r){
        for(Shape sound:sounds){
            sound.setRate(r);
        }
    }
    public void setVolume(double v){
        for(Shape sound:sounds){
            sound.setVolume(v);
        }
    }
    public void play(){
        for(Shape sound:sounds){
            sound.play();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Composite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public AudioClip getAudioClip() {
        return null;
    }
}
