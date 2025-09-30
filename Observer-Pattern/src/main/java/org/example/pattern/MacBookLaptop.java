package org.example.pattern;

/**
 * Concrete Observer 3 (MacBookLaptop)
 * Receives and displays weather updates on MacBook laptop
 */
public class MacBookLaptop implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("[MacBook Laptop] Weather update -> Temperature: " 
                + temperature + "°C, Humidity: " + humidity + "%");
    }
}
