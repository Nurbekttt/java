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
public class MusicSOL implements Shape{
    AudioClip sol1 = new AudioClip("file:src/sounds/316912__jaz-the-man-2__sol.wav");
    
    public void play() {
        sol1.play();
    }

    @Override
    public void setCycleCount(int c) {
        sol1.setCycleCount(c);
    }

    @Override
    public void setRate(double r) {
        sol1.setRate(r);
    }

    @Override
    public void setVolume(double v) {
        sol1.setVolume(v);
    }

    @Override
    public AudioClip getAudioClip() {
        return sol1;
    }
}
