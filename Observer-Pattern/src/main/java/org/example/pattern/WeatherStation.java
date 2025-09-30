package org.example.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject (Weather Station)
 * Maintains list of observers and notifies them of state changes
 */
public class WeatherStation implements WeatherSubject {
    private final List<WeatherObserver> observers;
    private float temperature;
    private float humidity;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setWeatherConditions(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}
