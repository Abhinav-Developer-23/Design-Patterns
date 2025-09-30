package org.example;

// Concrete Product - Linux TextField
public class LinuxTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering a text field in Linux style - Minimalist design, system font integration, clean borders");
    }
}
