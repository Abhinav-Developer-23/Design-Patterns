package org.example;

// Concrete Product - Mac TextField
public class MacTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering a text field in Mac style - Rounded borders, smooth focus animations, San Francisco font");
    }
}
