package org.example.pattern;

/**
 * ADAPTER PATTERN DEMONSTRATION
 * 
 * This example demonstrates the Adapter Pattern where:
 * - AudioPlayer (Client) can natively play MP3 files
 * - AdvancedMediaPlayer (Adaptee) can play MP4 and MKV files with different method signatures
 * - MediaAdapter (Adapter) bridges the gap between these incompatible interfaces
 * 
 * The pattern allows AudioPlayer to play MP4 and MKV files without modifying
 * its code or the AdvancedMediaPlayer implementations.
 */
public class Main {
    public static void main(String[] args) {
        // Create the client that uses MediaPlayer interface
        AudioPlayer audioPlayer = new AudioPlayer();

        System.out.println("=== Adapter Pattern Demo ===\n");
        
        // Test 1: Native support - plays directly without adapter
        System.out.println("Test 1: MP3 (Native Support)");
        audioPlayer.play("mp3", "song.mp3");
        System.out.println();
        
        // Test 2: Adapter pattern in action - MP4
        System.out.println("Test 2: MP4 (Using Adapter)");
        audioPlayer.play("mp4", "video.mp4");
        System.out.println();
        
        // Test 3: Adapter pattern in action - MKV
        System.out.println("Test 3: MKV (Using Adapter)");
        audioPlayer.play("mkv", "movie.mkv");
        System.out.println();
        
        // Test 4: Unsupported format
        System.out.println("Test 4: AVI (Unsupported Format)");
        audioPlayer.play("avi", "video.avi");
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("Notice how the AudioPlayer seamlessly uses different formats");
        System.out.println("without knowing about the underlying AdvancedMediaPlayer implementations!");
    }
}