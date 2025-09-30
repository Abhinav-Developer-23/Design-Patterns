package org.example;

// Concrete Factory - Linux Factory
public class LinuxFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
}

