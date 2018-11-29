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
public class MusicSI implements Shape{
    AudioClip si1 = new AudioClip("file:src/sounds/316913__jaz-the-man-2__si.wav");
    
    public void play() {
        si1.play();
    }

    @Override
    public void setCycleCount(int c) {
        si1.setCycleCount(c);
    }

    @Override
    public void setRate(double r) {
        si1.setRate(r);
    }

    @Override
    public void setVolume(double v) {
        si1.setVolume(v);
    }

    @Override
    public AudioClip getAudioClip() {
        return si1;
    }
}
