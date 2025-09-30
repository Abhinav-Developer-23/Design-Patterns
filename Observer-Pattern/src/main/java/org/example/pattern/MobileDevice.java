package org.example.pattern;

/**
 * Concrete Observer 1 (MobileDevice)
 * Receives and displays weather updates on mobile device
 */
public class MobileDevice implements WeatherObserver {
    private String name;

    public MobileDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity) {
        System.out.println("[" + name + " - Mobile] received weather update -> Temperature: " 
                + temperature + "°C, Humidity: " + humidity + "%");
    }
}
