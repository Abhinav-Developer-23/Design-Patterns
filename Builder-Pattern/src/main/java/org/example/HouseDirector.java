package org.example;

// Director class - constructs houses using the builder
public class HouseDirector {

    // Constructs a basic house
    public House constructBasicHouse() {
        return new House.HouseBuilder("Concrete Foundation", "Brick Walls")
                .setRoof("Asphalt Shingle Roof")
                .setWindows("Double-pane Windows")
                .setDoors("Wooden Door")
                .setInterior("Standard Interior Finishing")
                .build();
    }

    // Constructs a luxury house
    public House constructLuxuryHouse() {
        return new House.HouseBuilder("Reinforced Concrete Foundation", "Stone Walls")
                .setRoof("Slate Tile Roof")
                .setWindows("Triple-pane Energy-efficient Windows")
                .setDoors("Oak Double Doors")
                .setGarage(true)
                .setGarden(true)
                .setSwimmingPool(true)
                .setInterior("Luxury Interior with Marble Floors and Granite Countertops")
                .build();
    }

    // Constructs a simple cottage
    public House constructCottage() {
        return new House.HouseBuilder("Simple Concrete Foundation", "Wooden Walls")
                .setRoof("Wooden Shingle Roof")
                .setWindows("Small Cottage Windows")
                .setDoors("Rustic Wooden Door")
                .setGarden(true)
                .setInterior("Cozy Cottage Interior")
                .build();
    }

    // Constructs a modern minimalist house
    public House constructModernHouse() {
        return new House.HouseBuilder("Steel Foundation", "Glass and Concrete Walls")
                .setRoof("Flat Modern Roof")
                .setWindows("Floor-to-ceiling Windows")
                .setDoors("Automatic Sliding Doors")
                .setGarage(true)
                .setInterior("Minimalist Modern Interior")
                .build();
    }

    // Method to construct house using custom builder (for advanced users)
    public House constructHouse(House.HouseBuilder builder) {
        return builder.build();
    }
}
