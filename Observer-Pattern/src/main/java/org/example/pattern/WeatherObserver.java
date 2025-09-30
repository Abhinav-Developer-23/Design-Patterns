package org.example.pattern;

/**
 * Observer Interface
 * All observers must implement this interface
 */
public interface WeatherObserver {
    void update(float temperature, float humidity);
}
