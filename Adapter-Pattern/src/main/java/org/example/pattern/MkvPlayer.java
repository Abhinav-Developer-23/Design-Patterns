package org.example.pattern;

/**
 * CONCRETE ADAPTEE
 * 
 * This is another concrete implementation of the AdvancedMediaPlayer interface.
 * It knows how to play MKV files but not MP4 files.
 * 
 * Like Mp4Player, this class has useful functionality with an incompatible interface.
 */
public class MkvPlayer implements AdvancedMediaPlayer {
    
    @Override
    public void playMp4(String fileName) {
        // MkvPlayer specializes in MKV format only
        // Do nothing - MkvPlayer doesn't support MP4
    }

    @Override
    public void playMkv(String fileName) {
        // Core functionality: playing MKV files
        System.out.println("Playing MKV file: " + fileName);
    }
}
