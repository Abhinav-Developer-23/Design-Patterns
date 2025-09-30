# Observer Pattern - Weather Station

A complete implementation of the Observer Pattern using a weather station and multiple device observers.

## Pattern Overview

The Observer Pattern defines a one-to-many dependency between objects so that when one object (subject) changes state, all its dependents (observers) are notified and updated automatically.

## Project Structure

```
Observer-Pattern/
├── src/main/java/org/example/pattern/
│   ├── WeatherSubject.java         # Subject interface
│   ├── WeatherObserver.java        # Observer interface
│   ├── WeatherStation.java         # Concrete Subject
│   ├── MobileDevice.java           # Concrete Observer (Mobile)
│   ├── WindowsDesktop.java         # Concrete Observer (Desktop)
│   ├── MacBookLaptop.java          # Concrete Observer (Laptop)
│   └── Main.java                   # Demo application
├── pom.xml
├── Observer_Pattern_Explanation.md # Detailed explanation
└── README.md
```

## Components

### Interfaces
- **WeatherSubject** - Manages observer registration, removal, and notification
- **WeatherObserver** - Defines the update method for receiving weather updates

### Concrete Implementations
- **WeatherStation** - Maintains weather state (temperature, humidity) and notifies observers
- **MobileDevice** - Displays weather updates on mobile device
- **WindowsDesktop** - Displays weather updates on Windows desktop
- **MacBookLaptop** - Displays weather updates on MacBook laptop

## How to Run

### Using Java directly:

```bash
# Compile
cd Observer-Pattern/src/main/java
javac org/example/pattern/*.java

# Run
java org.example.pattern.Main
```

### Using Maven (if available):

```bash
cd Observer-Pattern
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.pattern.Main"
```

## Example Output

```
=== Weather Update 1 ===
[Phone - Mobile] received weather update -> Temperature: 28.3°C, Humidity: 65.0%
[Windows Desktop] Weather update -> Temperature: 28.3°C, Humidity: 65.0%
[MacBook Laptop] Weather update -> Temperature: 28.3°C, Humidity: 65.0%

=== Weather Update 2 ===
[Phone - Mobile] received weather update -> Temperature: 32.0°C, Humidity: 50.0%
[Windows Desktop] Weather update -> Temperature: 32.0°C, Humidity: 50.0%
[MacBook Laptop] Weather update -> Temperature: 32.0°C, Humidity: 50.0%

=== Removing MacBook observer ===

=== Weather Update 3 (without MacBook) ===
[Phone - Mobile] received weather update -> Temperature: 20.0°C, Humidity: 75.0%
[Windows Desktop] Weather update -> Temperature: 20.0°C, Humidity: 75.0%
```

## Key Features

✅ **Loose coupling** between weather station and device observers  
✅ **Dynamic observer registration/removal** at runtime  
✅ **One-to-many dependency** - one subject, multiple observers  
✅ **Automatic notification** when weather conditions change  
✅ **Multiple device types** with different display formats

## Pattern Benefits

1. **Extensibility** - Easy to add new observer types
2. **Maintainability** - Changes to observers don't affect the subject
3. **Reusability** - Subject and observers can be reused independently
4. **Flexibility** - Observers can be added/removed dynamically

## Real-World Use Cases

- Event handling in GUI frameworks
- Model-View-Controller (MVC) architecture
- Social media notifications
- Stock market price updates
- News feed subscriptions
- IoT sensor data broadcasting

## Reference

- [GeeksforGeeks - Observer Pattern](https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/)

## For More Details

See `Observer_Pattern_Explanation.md` for:
- Complete pattern explanation
- UML diagrams
- Benefits and use cases
- When to use this pattern
- Push vs Pull models
