package org.example.pattern;

/**
 * CONCRETE ADAPTEE
 * 
 * This is a concrete implementation of the AdvancedMediaPlayer interface.
 * It knows how to play MP4 files but not MKV files.
 * 
 * This class has useful functionality, but its interface is incompatible
 * with what the client (AudioPlayer) expects.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    
    @Override
    public void playMp4(String fileName) {
        // Core functionality: playing MP4 files
        System.out.println("Playing MP4 file: " + fileName);
    }

    @Override
    public void playMkv(String fileName) {
        // Mp4Player specializes in MP4 format only
        // Do nothing - Mp4Player doesn't support MKV
    }
}
