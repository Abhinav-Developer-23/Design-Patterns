package org.example.pattern;

/**
 * Concrete Observer 2 (WindowsDesktop)
 * Receives and displays weather updates on Windows desktop
 */
public class WindowsDesktop implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("[Windows Desktop] Weather update -> Temperature: " 
                + temperature + "°C, Humidity: " + humidity + "%");
    }
}
