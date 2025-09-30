package org.example.pattern;

/**
 * Demonstration of the State Design Pattern using a Vending Machine
 * 
 * The State Pattern allows an object to alter its behavior when its internal state changes.
 * The object will appear to change its class.
 */
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        
        System.out.println("=== VENDING MACHINE STATE PATTERN DEMO ===\n");
        
        // Display inventory
        vendingMachine.displayInventory();
        
        // Scenario 1: Successful purchase
        System.out.println("--- Scenario 1: Successful Purchase ---");
        vendingMachine.insertMoney(30);
        vendingMachine.selectProduct("A1"); // Coke for $25
        
        System.out.println();
        
        // Scenario 2: Insufficient funds
        System.out.println("--- Scenario 2: Insufficient Funds ---");
        vendingMachine.insertMoney(20);
        vendingMachine.selectProduct("B2"); // Juice for $30
        vendingMachine.insertMoney(15); // Add more money
        vendingMachine.selectProduct("B2"); // Try again
        
        System.out.println();
        
        // Scenario 3: Cancel transaction
        System.out.println("--- Scenario 3: Cancel Transaction ---");
        vendingMachine.insertMoney(50);
        vendingMachine.cancelTransaction();
        
        System.out.println();
        
        // Scenario 4: Invalid product code
        System.out.println("--- Scenario 4: Invalid Product Code ---");
        vendingMachine.insertMoney(30);
        vendingMachine.selectProduct("Z9"); // Invalid code
        vendingMachine.cancelTransaction();
        
        System.out.println();
        
        // Scenario 5: Multiple purchases to deplete stock
        System.out.println("--- Scenario 5: Depleting Stock ---");
        for (int i = 0; i < 4; i++) {
            vendingMachine.insertMoney(25);
            vendingMachine.selectProduct("A2"); // Buy Pepsi
        }
        
        vendingMachine.displayInventory();
        
        // Scenario 6: Try to use when out of stock
        System.out.println("--- Scenario 6: Out of Stock ---");
        vendingMachine.insertMoney(25);
        
        System.out.println();
        
        // Scenario 7: Refill products
        System.out.println("--- Scenario 7: Refill Products ---");
        vendingMachine.refillProducts();
        
        vendingMachine.displayInventory();
        
        // Scenario 8: Purchase after refill
        System.out.println("--- Scenario 8: Purchase After Refill ---");
        vendingMachine.insertMoney(20);
        vendingMachine.selectProduct("B1"); // Water for $15
        
        System.out.println();
        
        // Scenario 9: Try invalid operations in different states
        System.out.println("--- Scenario 9: Invalid Operations ---");
        vendingMachine.selectProduct("A1"); // Try to select without money
        vendingMachine.dispenseProduct(); // Try to dispense without selection
        vendingMachine.cancelTransaction(); // Try to cancel with no transaction
        
        System.out.println("\n=== DEMO COMPLETED ===");
    }
}