/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.media.AudioClip;

/**
 *
 * @author Админ
 */
public class MusicLA implements Shape{
    AudioClip la1 = new AudioClip("file:src/sounds/316902__jaz-the-man-2__la.wav");
    
    public void play() {
        la1.play();
    }

    @Override
    public void setCycleCount(int c) {
        la1.setCycleCount(c);
    }

    @Override
    public void setRate(double r) {
        la1.setRate(r);
    }

    @Override
    public void setVolume(double v) {
        la1.setVolume(v);
    }

    @Override
    public AudioClip getAudioClip() {
        return la1;
    }
}
