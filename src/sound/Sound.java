package sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.Objects;

public class Sound {

    Clip clip;
    URL url;
    boolean loop;

    public static Sound COIN = new Sound("/sounds/powerup.wav");
    public static Sound BLUE_BOY_ADVENTURE = new Sound("/sounds/BlueBoyAdventure.wav", true);
    public static Sound FANFARE = new Sound("/sounds/fanfare.wav");
    public static Sound POWERUP = new Sound("/sounds/powerup.wav");
    public static Sound UNLOCK = new Sound("/sounds/unlock.wav");

    public Sound(String url) {
        this(url, false);
    }
    public Sound(String url, boolean loop) {

            this.url = getClass().getResource(url);
            this.loop = loop;
    }

    public void play() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(this.url);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Sound Path:"+url);
        }
        if (loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        clip.start();
    }
    public void stop() {
        clip.stop();
    }
}
