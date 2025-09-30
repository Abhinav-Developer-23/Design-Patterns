package org.example.pattern;

/**
 * ADAPTEE INTERFACE
 * 
 * This is the incompatible interface that we want to adapt.
 * It has a different method signature than MediaPlayer interface.
 * 
 * Instead of a generic play() method, it has specific methods for each format.
 * This represents the "Adaptee" in the Adapter Pattern - the interface that
 * needs to be adapted to work with our Target (MediaPlayer) interface.
 */
public interface AdvancedMediaPlayer {
    /**
     * Play an MP4 video file
     * @param fileName The name of the MP4 file
     */
    void playMp4(String fileName);
    
    /**
     * Play an MKV video file
     * @param fileName The name of the MKV file
     */
    void playMkv(String fileName);
}
