package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo - Buttons & Text Fields ===\n");

        // Create Mac Factory and Components
        GUIFactory macFactory = new MacFactory();
        Button macButton = macFactory.createButton();
        TextField macTextField = macFactory.createTextField();

        System.out.println("--- Mac UI Components ---");
        System.out.print("Mac Button: ");
        macButton.paint();
        System.out.print("Mac Text Field: ");
        macTextField.render();

        // Create Windows Factory and Components
        GUIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        TextField windowsTextField = windowsFactory.createTextField();

        System.out.println("\n--- Windows UI Components ---");
        System.out.print("Windows Button: ");
        windowsButton.paint();
        System.out.print("Windows Text Field: ");
        windowsTextField.render();

        // Create Linux Factory and Components
        GUIFactory linuxFactory = new LinuxFactory();
        Button linuxButton = linuxFactory.createButton();
        TextField linuxTextField = linuxFactory.createTextField();

        System.out.println("\n--- Linux UI Components ---");
        System.out.print("Linux Button: ");
        linuxButton.paint();
        System.out.print("Linux Text Field: ");
        linuxTextField.render();

        System.out.println("\n=== Benefits of Abstract Factory Pattern ===");
        System.out.println("1. Creates families of related objects (buttons + text fields) without specifying concrete classes");
        System.out.println("2. Ensures consistent object creation across different platforms (Mac/Windows/Linux)");
        System.out.println("3. Makes it easy to switch between different UI themes/families");
        System.out.println("4. Guarantees compatibility between related components (Mac button + Mac text field)");
        System.out.println("5. Follows the Open/Closed principle - easy to extend with new OS support");
        System.out.println("6. Single point of control for creating entire UI component families");
    }
}