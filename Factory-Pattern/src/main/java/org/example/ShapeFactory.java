package org.example;

/**
 * ShapeFactory class - Factory in Factory Pattern
 * This class encapsulates the object creation logic and provides a factory method
 * to create different types of shapes based on the input parameter
 */
public class ShapeFactory {
    
    /**
     * Factory method to create shape objects
     * @param shapeType the type of shape to create
     * @return Shape object or null if invalid type
     */
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        
        // Convert to uppercase for case-insensitive comparison
        shapeType = shapeType.toUpperCase();
        
        switch (shapeType) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                System.out.println("Unknown shape type: " + shapeType);
                return null;
        }
    }
    
    /**
     * Method to get all available shape types
     * @return array of available shape types
     */
    public String[] getAvailableShapes() {
        return new String[]{"CIRCLE", "RECTANGLE", "SQUARE"};
    }
}
