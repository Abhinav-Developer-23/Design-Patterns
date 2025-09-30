package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo - House Construction ===\n");

        HouseDirector director = new HouseDirector();

        // 1. Construct a basic house using the director
        System.out.println("1. BASIC HOUSE:");
        House basicHouse = director.constructBasicHouse();
        System.out.println(basicHouse);

        // 2. Construct a luxury house using the director
        System.out.println("2. LUXURY HOUSE:");
        House luxuryHouse = director.constructLuxuryHouse();
        System.out.println(luxuryHouse);

        // 3. Construct a cottage using the director
        System.out.println("3. COZY COTTAGE:");
        House cottage = director.constructCottage();
        System.out.println(cottage);

        // 4. Construct a modern house using the director
        System.out.println("4. MODERN MINIMALIST HOUSE:");
        House modernHouse = director.constructModernHouse();
        System.out.println(modernHouse);

        // 5. Custom house construction using builder directly (advanced usage)
        System.out.println("5. CUSTOM HOUSE (Built directly with Builder):");
        House customHouse = new House.HouseBuilder("Eco-friendly Foundation", "Recycled Material Walls")
                .setRoof("Solar Panel Roof")
                .setWindows("Smart Energy-efficient Windows")
                .setDoors("Biometric Security Door")
                .setGarage(true)
                .setGarden(true)
                .setSwimmingPool(false) // Eco-friendly choice
                .setInterior("Sustainable Green Interior with Smart Home Technology")
                .build();
        System.out.println(customHouse);

        // 6. Demonstrate method chaining and flexibility
        System.out.println("6. DEMONSTRATING BUILDER FLEXIBILITY:");
        House flexibleHouse = new House.HouseBuilder("Standard Foundation", "Brick Walls")
                .setWindows("Large Windows")  // Only setting some parameters
                .setGarden(true)              // Selective customization
                .build();
        System.out.println("Minimal configuration house:");
        System.out.println(flexibleHouse);

        System.out.println("=== Builder Pattern Benefits ===");
        System.out.println("✅ Step-by-step construction of complex objects");
        System.out.println("✅ Method chaining for fluent API");
        System.out.println("✅ Different representations of the same object type");
        System.out.println("✅ Encapsulation of object creation logic");
        System.out.println("✅ Easy to add new house types without changing existing code");
        System.out.println("✅ Reduces constructor parameter complexity");
        System.out.println("✅ Immutable objects (thread-safe)");
    }
}
