package org.example.pattern;

/**
 * State interface for the Vending Machine
 * Defines all possible operations that can be performed on the vending machine
 */
public interface VendingMachineState {
    
    /**
     * Insert money into the vending machine
     * @param amount The amount of money to insert
     */
    void insertMoney(int amount);
    
    /**
     * Select a product from the vending machine
     * @param productCode The code of the product to select
     */
    void selectProduct(String productCode);
    
    /**
     * Dispense the selected product
     */
    void dispenseProduct();
    
    /**
     * Cancel the transaction and return money
     */
    void cancelTransaction();
    
    /**
     * Refill the vending machine with products
     */
    void refillProducts();
}
