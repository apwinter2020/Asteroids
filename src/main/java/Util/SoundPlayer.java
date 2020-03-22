package main.java.Util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    private final static SoundPlayer SoundPlayerInstance = new SoundPlayer();

    private static float BGVolume = 1;
    private static float soundVolume = 1;

    private static AudioInputStream audioInputStream;
    private static Clip clip;
    private static Clip BGMusicClip;

    private static boolean muteSound = false;

    public static SoundPlayer getInstance() {
        return SoundPlayerInstance;
    }

    public static void play(String path) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(20f * (float) Math.log10(soundVolume));

            if (muteSound) {
                BooleanControl booleanControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
                booleanControl.setValue(true);
            } else {
                BooleanControl booleanControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
                booleanControl.setValue(false);
            }

            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playBGMusic(String path) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            BGMusicClip = AudioSystem.getClip();
            BGMusicClip.open(audioInputStream);
            BGMusicClip.loop(Integer.MAX_VALUE);
            BGMusicClip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void decreaseBGMusicVolume() {
        BGVolume -= 0.06;

        FloatControl floatControl = (FloatControl) BGMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
        floatControl.setValue(20f * (float) Math.log10(BGVolume));
    }

    public static void increaseBGMusicVolume() {
        if (BGVolume < 1) {
            BGVolume += 0.06;

            FloatControl floatControl = (FloatControl) BGMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(20f * (float) Math.log10(BGVolume));
        }
    }

    public static void decreaseSound() {
        soundVolume -= 0.06;

        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        floatControl.setValue(20f * (float) Math.log10(soundVolume));
    }

    public static void increaseSound() {
        if (soundVolume < 1) {
            soundVolume += 0.06;

            FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(20f * (float) Math.log10(soundVolume));
        }
    }

    public static void muteBGMusic() {
        BooleanControl booleanControl = (BooleanControl) BGMusicClip.getControl(BooleanControl.Type.MUTE);
        booleanControl.setValue(true);
    }


    public static void unMuteBGMusic() {
        BooleanControl booleanControl = (BooleanControl) BGMusicClip.getControl(BooleanControl.Type.MUTE);
        booleanControl.setValue(false);
    }

    public static void setMuteSound(boolean muteSound) {
        SoundPlayer.muteSound = muteSound;
    }
}
