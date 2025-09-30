package org.example;

// Concrete Factory - Mac Factory
public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
}

