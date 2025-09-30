package org.example.pattern;

/**
 * Subject Interface (Observable)
 * Defines methods for managing observers
 */
public interface WeatherSubject {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}
