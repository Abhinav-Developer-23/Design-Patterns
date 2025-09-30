package org.example.pattern;

/**
 * Idle State - Waiting for money to be inserted
 */
public class IdleState implements VendingMachineState {
    private VendingMachine vendingMachine;
    
    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Please insert a valid amount of money.");
            return;
        }
        
        System.out.println("Money inserted: $" + amount);
        vendingMachine.addMoney(amount);
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }
    
    @Override
    public void selectProduct(String productCode) {
        System.out.println("Please insert money first.");
    }
    
    @Override
    public void dispenseProduct() {
        System.out.println("Please insert money and select a product first.");
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
    }
}
