package org.example;

// Product class - House
public class House {
    private String foundation;
    private String walls;
    private String roof;
    private String windows;
    private String doors;
    private boolean hasGarage;
    private boolean hasGarden;
    private boolean hasSwimmingPool;
    private String interior;

    // Private constructor to enforce builder pattern
    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.windows = builder.windows;
        this.doors = builder.doors;
        this.hasGarage = builder.hasGarage;
        this.hasGarden = builder.hasGarden;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.interior = builder.interior;
    }

    // Getters
    public String getFoundation() { return foundation; }
    public String getWalls() { return walls; }
    public String getRoof() { return roof; }
    public String getWindows() { return windows; }
    public String getDoors() { return doors; }
    public boolean hasGarage() { return hasGarage; }
    public boolean hasGarden() { return hasGarden; }
    public boolean hasSwimmingPool() { return hasSwimmingPool; }
    public String getInterior() { return interior; }



    // Builder class - nested static class
    public static class HouseBuilder {
        private String foundation;
        private String walls;
        private String roof;
        private String windows;
        private String doors;
        private boolean hasGarage;
        private boolean hasGarden;
        private boolean hasSwimmingPool;
        private String interior;

        // Mandatory parameters - foundation and walls
        public HouseBuilder(String foundation, String walls) {
            this.foundation = foundation;
            this.walls = walls;
        }

        // Optional parameters - method chaining
        public HouseBuilder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder setWindows(String windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder setDoors(String doors) {
            this.doors = doors;
            return this;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setInterior(String interior) {
            this.interior = interior;
            return this;
        }

        // Build method - creates the House object
        public House build() {
            return new House(this);
        }
    }
}
