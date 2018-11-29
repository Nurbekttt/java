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
public class MusicMI implements Shape{
    AudioClip mi1 = new AudioClip("file:src/sounds/316906__jaz-the-man-2__mi.wav");
    
    public void play() {
        mi1.play();
    }

    @Override
    public void setCycleCount(int c) {
        mi1.setCycleCount(c);
    }

    @Override
    public void setRate(double r) {
        mi1.setRate(r);
    }

    @Override
    public void setVolume(double v) {
        mi1.setVolume(v);
    }

    @Override
    public AudioClip getAudioClip() {
        return mi1;
    }
}
