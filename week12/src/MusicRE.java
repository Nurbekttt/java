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
public class MusicRE implements Shape{
    AudioClip re1 = new AudioClip("file:src/sounds/316908__jaz-the-man-2__re.wav");
    
    public void play() {
        re1.play();
    }

    @Override
    public void setCycleCount(int c) {
        re1.setCycleCount(c);
    }

    @Override
    public void setRate(double r) {
        re1.setRate(r);
    }

    @Override
    public void setVolume(double v) {
        re1.setVolume(v);
    }

    @Override
    public AudioClip getAudioClip() {
        return re1;
    }
}
