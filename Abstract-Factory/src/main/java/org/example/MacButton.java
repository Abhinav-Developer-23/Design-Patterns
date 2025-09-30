package org.example;

// Concrete Product - Mac Button
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Mac style - Rounded corners, smooth animations");
    }
}

