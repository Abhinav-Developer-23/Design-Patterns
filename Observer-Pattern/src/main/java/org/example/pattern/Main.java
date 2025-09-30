package org.example.pattern;

import java.util.logging.Logger;

/**
 * Main Class (Client)
 * Demonstrates the Observer Pattern with a weather station example
 * 
 * Reference: https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/
 */
public class Main {
    public static void main(String[] args) {
        // Create a WeatherStation (Subject)
        WeatherStation weatherStation = new WeatherStation();
        final Logger logger = Logger.getAnonymousLogger();
        
        // Create observers
        MobileDevice phone = new MobileDevice("Phone");
        WindowsDesktop windowsDesktop = new WindowsDesktop();
        MacBookLaptop macBook = new MacBookLaptop();

        // Register observers with the subject
        weatherStation.addObserver(phone);
        weatherStation.addObserver(windowsDesktop);
        weatherStation.addObserver(macBook);
        
        logger.info("Observer Pattern Demo - Weather Station");
        
        // Change weather conditions (this will notify all observers)
        System.out.println("\n=== Weather Update 1 ===");
        weatherStation.setWeatherConditions(28.3f, 65.0f);
        
        System.out.println("\n=== Weather Update 2 ===");
        weatherStation.setWeatherConditions(32.0f, 50.0f);

        // Remove an observer and update weather conditions again
        System.out.println("\n=== Removing MacBook observer ===");
        weatherStation.removeObserver(macBook);
        
        System.out.println("\n=== Weather Update 3 (without MacBook) ===");
        weatherStation.setWeatherConditions(20.0f, 75.0f);
    }
}