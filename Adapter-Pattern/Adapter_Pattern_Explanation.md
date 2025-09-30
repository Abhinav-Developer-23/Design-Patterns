# Adapter Pattern

## Overview
The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by wrapping an existing class with a new interface.

## Intent
- Convert the interface of a class into another interface that clients expect
- Allow classes to work together that couldn't otherwise because of incompatible interfaces
- Provide a different interface to an object

## Components

### 1. Target Interface (`MediaPlayer`)
- The interface that the client expects to use
- Defines the domain-specific interface that the client uses

### 2. Adaptee (`AdvancedMediaPlayer`, `VlcPlayer`, `Mp4Player`)
- The existing interface that needs adapting
- Contains useful behavior but has an incompatible interface

### 3. Adapter (`MediaAdapter`)
- Implements the Target interface
- Wraps the Adaptee object
- Translates requests from the Target interface to the Adaptee interface

### 4. Client (`AudioPlayer`, `Main`)
- Collaborates with objects conforming to the Target interface

## Real-World Example
In this implementation:
- **Target**: `MediaPlayer` interface - the standard interface our audio player expects
- **Adaptee**: `AdvancedMediaPlayer` interface with `Mp4Player` and `MkvPlayer` implementations
- **Adapter**: `MediaAdapter` - converts MediaPlayer calls to AdvancedMediaPlayer calls
- **Client**: `AudioPlayer` - uses MediaPlayer interface and employs the adapter for advanced formats

## Structure
```
Client (AudioPlayer)
    |
    v
Target Interface (MediaPlayer)
    ^
    |
    |--- Direct Implementation (for MP3)
    |
    |--- Adapter (MediaAdapter)
            |
            v
         Adaptee Interface (AdvancedMediaPlayer)
            ^
            |
            |--- Mp4Player
            |--- MkvPlayer
```

## When to Use
1. You want to use an existing class, but its interface doesn't match what you need
2. You want to create a reusable class that cooperates with unrelated classes with incompatible interfaces
3. You need to use several existing subclasses, but it's impractical to adapt their interface by subclassing each one

## Advantages
- **Single Responsibility Principle**: Separates interface conversion from business logic
- **Open/Closed Principle**: Can introduce new adapters without breaking existing code
- **Flexibility**: Allows incompatible interfaces to work together
- **Reusability**: Existing classes can be reused without modification

## Disadvantages
- Increases overall complexity by adding new interfaces and classes
- Sometimes it's simpler to change the service class to match the rest of your code

## Types of Adapters
1. **Class Adapter**: Uses multiple inheritance (not possible in Java with classes)
2. **Object Adapter**: Uses composition (used in this implementation)

## Real-World Applications
- Legacy system integration
- Third-party library integration
- API versioning compatibility
- Data format conversion
- GUI toolkit adapters
- Database drivers (JDBC)
