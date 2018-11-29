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
public interface Shape {
    public void play();
    public void setCycleCount(int c);
    public void setRate(double r);
    public void setVolume(double v);


    AudioClip getAudioClip();
}
