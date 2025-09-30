package org.example.pattern;

/**
 * Dispensing State - Product is being dispensed
 */
public class DispensingState implements VendingMachineState {
    private VendingMachine vendingMachine;
    
    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertMoney(int amount) {
        System.out.println("Please wait, dispensing product...");
    }
    
    @Override
    public void selectProduct(String productCode) {
        System.out.println("Already dispensing a product. Please wait.");
    }
    
    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getSelectedProduct();
        
        if (product == null) {
            System.out.println("Error: No product selected.");
            vendingMachine.setState(vendingMachine.getIdleState());
            return;
        }
        
        System.out.println("Dispensing " + product.getName() + "...");
        vendingMachine.reduceStock(product.getCode());
        
        // Calculate and return change
        int change = vendingMachine.getInsertedMoney() - product.getPrice();
        if (change > 0) {
            System.out.println("Returning change: $" + change);
        }
        
        System.out.println("Please collect your " + product.getName());
        
        // Reset state
        vendingMachine.resetMoney();
        vendingMachine.resetSelectedProduct();
        
        // Check if out of stock
        if (!vendingMachine.hasAnyStock()) {
            System.out.println("Vending machine is now out of stock.");
            vendingMachine.setState(vendingMachine.getOutOfStockState());
        } else {
            vendingMachine.setState(vendingMachine.getIdleState());
        }
    }
    
    @Override
    public void cancelTransaction() {
        System.out.println("Cannot cancel transaction while dispensing.");
    }
    
    @Override
    public void refillProducts() {
        System.out.println("Cannot refill while dispensing product.");
    }
}
