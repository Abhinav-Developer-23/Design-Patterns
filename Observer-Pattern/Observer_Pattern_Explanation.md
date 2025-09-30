# Observer Pattern - Weather Station Example

## Overview
The **Observer Pattern** is a behavioral design pattern that defines a one-to-many dependency between objects. When one object (the subject) changes state, all its dependents (observers) are notified and updated automatically.

## Problem
Imagine you have a weather station that collects weather data, and you want to display this data on multiple devices (mobile phones, desktops, laptops). Without the Observer Pattern:
- You'd need to manually update each device when weather changes
- Tight coupling between the weather station and display devices
- Difficulty adding new display devices without modifying existing code
- Hard to maintain and extend the system

## Solution
The Observer Pattern solves this by:
1. Defining a **Subject** interface that manages observers
2. Creating a concrete subject (WeatherStation) that maintains state
3. Defining an **Observer** interface for receiving updates
4. Implementing concrete observers (devices) that react to changes
5. Allowing dynamic subscription/unsubscription at runtime

## Components

### 1. Subject Interface
```java
WeatherSubject.java
```
Defines methods for:
- `addObserver()` - Register an observer
- `removeObserver()` - Unregister an observer
- `notifyObservers()` - Notify all observers of changes

### 2. Concrete Subject
```java
WeatherStation.java
```
- Implements the WeatherSubject interface
- Maintains weather state (temperature, humidity)
- Notifies all registered observers when state changes
- Manages the list of observers using ArrayList

### 3. Observer Interface
```java
WeatherObserver.java
```
Defines the `update()` method that all concrete observers must implement to receive weather updates.

### 4. Concrete Observers
- `MobileDevice.java` - Displays weather updates on mobile device
- `WindowsDesktop.java` - Displays weather updates on Windows desktop
- `MacBookLaptop.java` - Displays weather updates on MacBook laptop

Each concrete observer implements the WeatherObserver interface and defines its own display logic.

### 5. Demo
- `Main.java` - Demonstrates the pattern with weather updates and dynamic observer removal

## How It Works

```
┌─────────────────────┐
│  <<interface>>      │
│  WeatherSubject     │
├─────────────────────┤
│ + addObserver()     │
│ + removeObserver()  │
│ + notifyObservers() │
└──────────▲──────────┘
           │
           │ implements
           │
┌──────────┴──────────┐
│  WeatherStation     │
│ (Concrete Subject)  │
├─────────────────────┤
│ - observers: List   │
│ - temperature       │
│ - humidity          │
├─────────────────────┤
│ + setWeatherCond()  │
│ + notifyObservers() │
└──────────┬──────────┘
           │
           │ notifies
           │
           ▼
┌─────────────────────┐
│  <<interface>>      │
│  WeatherObserver    │
├─────────────────────┤
│ + update(t,h)       │
└──────────▲──────────┘
           │
           │ implements
           │
    ┌──────┴──────┬──────────────┐
    │             │              │
┌───▼────────┐ ┌──▼──────────┐ ┌─▼────────────┐
│MobileDevice│ │WindowsDesktop│ │MacBookLaptop │
└────────────┘ └──────────────┘ └──────────────┘
```

## Key Principles

### 1. **Loose Coupling**
The subject knows nothing about concrete observer classes, only that they implement the WeatherObserver interface.

### 2. **Open/Closed Principle**
Open for extension (add new observer types), closed for modification (no changes to subject when adding observers).

### 3. **Dynamic Subscription**
Observers can subscribe or unsubscribe at runtime without affecting the system.

## Benefits

1. **Loose Coupling**: Subject and observers are loosely coupled
2. **Dynamic Relationships**: Observers can be added/removed at runtime
3. **Broadcast Communication**: One change triggers multiple updates automatically
4. **Reusability**: Subjects and observers can be reused independently
5. **Scalability**: Easy to add new observer types without modifying existing code

## Usage Example

```java
// Create the subject
WeatherStation weatherStation = new WeatherStation();

// Create observers
MobileDevice phone = new MobileDevice("Phone");
WindowsDesktop desktop = new WindowsDesktop();

// Register observers
weatherStation.addObserver(phone);
weatherStation.addObserver(desktop);

// Update weather - all observers are notified automatically
weatherStation.setWeatherConditions(28.3f, 65.0f);

// Remove an observer
weatherStation.removeObserver(desktop);

// Next update won't notify desktop
weatherStation.setWeatherConditions(32.0f, 50.0f);
```

## When to Use

Use the Observer Pattern when:
- A change to one object requires changing others, and you don't know how many
- An object should notify other objects without knowing who they are
- You want loose coupling between interacting objects
- You need a publish-subscribe mechanism
- Changes in one part should trigger updates in other parts

## Real-World Applications

- **Event Management Systems**: GUI frameworks (button clicks, mouse events)
- **MVC Architecture**: Model notifies views of data changes
- **Social Media**: Notification systems (followers get updates when you post)
- **Stock Market**: Price change notifications to traders/apps
- **News Feeds**: Subscribers receive updates when new content is published
- **Weather Apps**: Multiple devices showing same weather data
- **Messaging Systems**: Chat applications, notification services
- **IoT Devices**: Sensor data broadcasting to multiple consumers

## Push vs Pull Model

### Push Model (Used in this example)
The subject pushes all data to observers in the `update()` method.

```java
void update(float temperature, float humidity);
```

**Pros**: Simple, observers get all data immediately  
**Cons**: Less flexible, observers get data they might not need

### Pull Model (Alternative)
The subject notifies observers, observers pull the data they need.

```java
void update(WeatherStation station); // Observers call getters on station
```

**Pros**: More flexible, observers get only what they need  
**Cons**: Tighter coupling to subject

## Running the Example

```bash
# Navigate to project directory
cd Observer-Pattern

# Compile
javac -d target/classes src/main/java/org/example/pattern/*.java

# Run
java -cp target/classes org.example.pattern.Main
```

Or using Maven:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.pattern.Main"
```

## Expected Output

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

## Reference
- [GeeksforGeeks - Observer Pattern](https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/)

## Key Takeaway

The Observer Pattern establishes a one-to-many dependency where the subject automatically notifies all observers when its state changes. This promotes loose coupling, makes the system easy to extend, and is fundamental to event-driven programming, MVC architecture, and reactive systems.
