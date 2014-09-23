package service;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Waldema
 */
public class Sons {

    public void somBG(){
          try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src//sound//bgsound.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }catch(Exception ex){
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
    }
    public void finalBgSound(){
        try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src//sound//battle.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }catch(Exception ex){
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
    }
    public void playMisselSound(){
    try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src//sound//missel.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }catch(Exception ex){
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
}
    public void playSoundSuper(){
    try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src//sound//misselSuper.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }catch(Exception ex){
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
}

}
