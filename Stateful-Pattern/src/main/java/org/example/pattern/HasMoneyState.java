package org.example.pattern;

/**
 * Has Money State - Money has been inserted, waiting for product selection
 */
public class HasMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;
    
    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    
    @Override
    public void insertMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Please insert a valid amount of money.");
            return;
        }
        
        System.out.println("Additional money inserted: $" + amount);
        vendingMachine.addMoney(amount);
        System.out.println("Total money: $" + vendingMachine.getInsertedMoney());
    }
    
    @Override
    public void selectProduct(String productCode) {
        Product product = vendingMachine.getProduct(productCode);
        
        if (product == null) {
            System.out.println("Invalid product code: " + productCode);
            return;
        }
        
        if (!vendingMachine.isProductAvailable(productCode)) {
            System.out.println("Sorry, " + product.getName() + " is out of stock.");
            return;
        }
        
        if (vendingMachine.getInsertedMoney() < product.getPrice()) {
            int needed = product.getPrice() - vendingMachine.getInsertedMoney();
            System.out.println("Insufficient funds. Need $" + needed + " more.");
            return;
        }
        
        System.out.println("Product selected: " + product.getName());
        vendingMachine.setSelectedProduct(product);
        vendingMachine.setState(vendingMachine.getDispensingState());
        vendingMachine.dispenseProduct();
    }
    
    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first.");
    }
    
    @Override
    public void cancelTransaction() {
        int returnedMoney = vendingMachine.returnMoney();
        System.out.println("Transaction cancelled. Returning $" + returnedMoney);
        vendingMachine.setState(vendingMachine.getIdleState());
    }
    
    @Override
    public void refillProducts() {
        System.out.println("Cannot refill while transaction is in progress. Please cancel first.");
    }
}
