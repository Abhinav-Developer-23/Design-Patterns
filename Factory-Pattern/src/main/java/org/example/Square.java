package org.example;

/**
 * Square class - Concrete Product in Factory Pattern
 * Implements the Shape interface
 */
public class Square implements Shape {
    
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
        System.out.println("*********");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*       *");
        System.out.println("*********");
        System.out.println();
    }
}
