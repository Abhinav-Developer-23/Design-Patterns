package org.example;

public class Singleton {

    // Volatile ensures changes are visible across threads
    private static volatile Singleton instance;

    // Private constructor prevents instantiation
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (Singleton.class) {
                if (instance == null) {  // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

