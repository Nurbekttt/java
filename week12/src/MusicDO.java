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
public class MusicDO implements Shape{
    AudioClip do1 = new AudioClip("file:src/sounds/316898__jaz-the-man-2__do.wav");

    
    public void play() {
        do1.play();
    }

    @Override
    public void setCycleCount(int c) {
        do1.setCycleCount(c);
    }

    @Override
    public void setRate(double r) {
        do1.setRate(r);
    }

    @Override
    public void setVolume(double v) {
        do1.setVolume(v);
    }

    @Override
    public AudioClip getAudioClip() {
        return do1;
    }
}
