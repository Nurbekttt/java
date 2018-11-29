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
public class MusicFA implements Shape{
    AudioClip fa1 = new AudioClip("file:src/sounds/316904__jaz-the-man-2__fa.wav");
    
    public void play() {
        fa1.play();
    }

    @Override
    public void setCycleCount(int c) {
        fa1.setCycleCount(c);
    }

    @Override
    public void setRate(double r) {
        fa1.setRate(r);
    }

    @Override
    public void setVolume(double v) {
        fa1.setVolume(v);

    }

    public AudioClip getAudioClip() {
        return fa1;
    }
}
