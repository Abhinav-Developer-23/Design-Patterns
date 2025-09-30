package org.example;

// Concrete Product - Linux Button
public class LinuxButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Linux style - Minimalist design, system theme integration");
    }
}

