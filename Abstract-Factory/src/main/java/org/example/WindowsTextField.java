package org.example;

// Concrete Product - Windows TextField
public class WindowsTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering a text field in Windows style - Sharp borders, flat design, Segoe UI font");
    }
}
