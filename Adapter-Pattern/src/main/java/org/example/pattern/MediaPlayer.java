package org.example.pattern;

/**
 * TARGET INTERFACE
 * 
 * This is the interface that the client (AudioPlayer) expects to use.
 * The client is designed to work with this interface.
 * 
 * In the Adapter Pattern, this represents the "Target" - the interface
 * that we want to use, but need to adapt other incompatible interfaces to work with it.
 */
public interface MediaPlayer {
    /**
     * Play a media file of specified type
     * @param audioType The format/type of media (mp3, mp4, mkv, etc.)
     * @param fileName The name of the file to play
     */
    void play(String audioType, String fileName);
}
