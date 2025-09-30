package org.example.pattern;

/**
 * Out of Stock State - No products available
 */
public class OutOfStockState implements VendingMachineState {
    private VendingMachine vendingMachine;
    
    public OutOfStockState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertMoney(int amount) {
        System.out.println("Sorry, vending machine is out of stock. Cannot accept money.");
    }
    
    @Override
    public void selectProduct(String productCode) {
        System.out.println("Sorry, vending machine is out of stock.");
    }
    
    @Override
    public void dispenseProduct() {
        System.out.println("No products available.");
    }
    
    @Override
    public void cancelTransaction() {
        System.out.println("No transaction to cancel.");
    }
    
    @Override
    public void refillProducts() {
        System.out.println("Refilling products...");
        vendingMachine.refillAllProducts();
        System.out.println("Products refilled successfully!");
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
