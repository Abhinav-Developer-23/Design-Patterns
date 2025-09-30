package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===\n");

        // Create Mac Factory and Button
        GUIFactory macFactory = new MacFactory();
        Button macButton = macFactory.createButton();
        System.out.print("Mac Button: ");
        macButton.paint();

        // Create Windows Factory and Button
        GUIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        System.out.print("Windows Button: ");
        windowsButton.paint();

        // Create Linux Factory and Button
        GUIFactory linuxFactory = new LinuxFactory();
        Button linuxButton = linuxFactory.createButton();
        System.out.print("Linux Button: ");
        linuxButton.paint();

        System.out.println("\n=== Benefits of Abstract Factory Pattern ===");
        System.out.println("1. Creates families of related objects without specifying concrete classes");
        System.out.println("2. Ensures consistent object creation across different platforms");
        System.out.println("3. Makes it easy to switch between different UI themes/families");
        System.out.println("4. Follows the Open/Closed principle - easy to extend with new OS support");
    }
}