import javafx.scene.effect.Shadow;
import javafx.scene.media.AudioClip;

public class Composite1 implements Shape {
    int cycleCount = 1;
    double rate = 1;
    double volume = 50;
    double delay = 1;
    String src;
    AudioClip audioClip;

    public Composite1(String src) {
        this.src = src;
        audioClip = new AudioClip(getClass().getClassLoader().getResource(src).toString());
    }

    public Composite1(double rate, double delay, Shape nota) {
        this.rate = rate;
        this.delay = delay;
        this.audioClip=nota.getAudioClip();
        audioClip.setCycleCount(cycleCount);
        audioClip.setRate(rate);
        audioClip.setVolume(volume);


    }
    public void setCycleCount(int cycleCount) {
        this.cycleCount = cycleCount;
        audioClip.setCycleCount(cycleCount);
    }

    public void setRate(double rate) {
        this.rate = rate;
        audioClip.setRate(rate);
    }

    @Override
    public void setVolume(double v) {
        audioClip.setVolume(volume);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        audioClip.setVolume(volume);
    }

    public void play() {
        audioClip.play();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public double getDelay() {
        return delay;
    }

    @Override
    public AudioClip getAudioClip() {
        return audioClip;
    }
}
