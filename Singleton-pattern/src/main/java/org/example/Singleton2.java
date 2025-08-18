package org.example;

public class Singleton2 {

    // Private constructor prevents instantiation
    private Singleton2() {
    }

    // Inner static helper class
    private static class SingletonHelper {
        // Instance created only when getInstance() is called
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    // Global access point
    public static Singleton2 getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

