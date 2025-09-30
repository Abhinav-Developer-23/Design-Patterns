package org.example;

// Concrete Product - Windows Button
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Windows style - Sharp corners, flat design");
    }
}

