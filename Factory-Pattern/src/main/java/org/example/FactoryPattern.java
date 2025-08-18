package org.example;

public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        for (String type : factory.getAvailableShapes()) {
            Shape shape = factory.getShape(type);
            if (shape != null) shape.draw();
        }

        // Try an invalid type
        Shape unknown = factory.getShape("triangle");
        if (unknown == null)
            System.out.println("Unknown shape: triangle");
    }
}
