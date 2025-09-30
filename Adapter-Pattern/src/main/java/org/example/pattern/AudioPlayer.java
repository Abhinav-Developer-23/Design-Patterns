package org.example.pattern;

/**
 * CLIENT CLASS
 * 
 * This is the main class that uses the MediaPlayer interface.
 * It has built-in support for some formats (MP3) but uses the Adapter
 * to extend its capabilities to support other formats (MP4, MKV).
 * 
 * The client doesn't need to know about AdvancedMediaPlayer or its implementations.
 * It only works with the MediaPlayer interface - the Adapter handles the complexity.
 */
public class AudioPlayer implements MediaPlayer {
    
    // Reference to the adapter (created on-demand)
    private MediaAdapter mediaAdapter;

    /**
     * The main play method that demonstrates when to use the Adapter
     * 
     * @param audioType The format type (mp3, mp4, mkv, etc.)
     * @param fileName The file to play
     */
    @Override
    public void play(String audioType, String fileName) {
        // Built-in support for MP3 - no adapter needed
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        }
        // Use adapter for formats that need AdvancedMediaPlayer
        // The adapter bridges the gap between MediaPlayer and AdvancedMediaPlayer interfaces
        else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("mkv")) {
            // Create adapter on-demand
            mediaAdapter = new MediaAdapter(audioType);
            // Use the adapter through the MediaPlayer interface
            mediaAdapter.play(audioType, fileName);
        } 
        // Unsupported formats
        else {
            System.out.println("Invalid media format: " + audioType + " is not supported.");
        }
    }
}
