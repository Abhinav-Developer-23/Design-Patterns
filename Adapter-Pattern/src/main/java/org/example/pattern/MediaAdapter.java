package org.example.pattern;

/**
 * ADAPTER CLASS - The Heart of the Adapter Pattern
 * 
 * This class "adapts" the AdvancedMediaPlayer interface to the MediaPlayer interface.
 * It implements the Target interface (MediaPlayer) and wraps the Adaptee (AdvancedMediaPlayer).
 * 
 * The adapter translates calls from the interface the client expects (MediaPlayer.play())
 * to the interface that the adaptee provides (AdvancedMediaPlayer.playMp4(), playMkv()).
 * 
 * This is an Object Adapter (uses composition) rather than a Class Adapter (uses inheritance).
 */
public class MediaAdapter implements MediaPlayer {
    
    // The adapter "has-a" relationship with the Adaptee
    private AdvancedMediaPlayer advancedMediaPlayer;

    /**
     * Constructor: Creates the appropriate player based on the audio type
     * This demonstrates the Factory pattern within the Adapter pattern
     * 
     * @param audioType The type of media format to handle
     */
    public MediaAdapter(String audioType) {
        // Determine which concrete Adaptee to instantiate
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        } else if (audioType.equalsIgnoreCase("mkv")) {
            advancedMediaPlayer = new MkvPlayer();
        }
    }

    /**
     * ADAPTATION METHOD
     * 
     * This method implements the Target interface (MediaPlayer)
     * and translates the call to the appropriate Adaptee method.
     * 
     * It converts: play(type, file) -> playMp4(file) or playMkv(file)
     */
    @Override
    public void play(String audioType, String fileName) {
        // Translate the generic play() call to specific playXxx() calls
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("mkv")) {
            advancedMediaPlayer.playMkv(fileName);
        }
    }
}
