package org.example.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Context class - Vending Machine
 * Maintains the current state and delegates operations to the state objects
 */
public class VendingMachine {
    private VendingMachineState currentState;
    private VendingMachineState idleState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispensingState;
    private VendingMachineState outOfStockState;
    
    private Map<String, Product> inventory;
    private Map<String, Integer> stock;
    private int insertedMoney;
    private Product selectedProduct;
    
    public VendingMachine() {
        // Initialize states
        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensingState = new DispensingState(this);
        outOfStockState = new OutOfStockState(this);
        
        // Initialize inventory
        inventory = new HashMap<>();
        stock = new HashMap<>();
        
        // Add some initial products
        addProduct(new Product("A1", "Coke", 25), 5);
        addProduct(new Product("A2", "Pepsi", 25), 5);
        addProduct(new Product("B1", "Water", 15), 5);
        addProduct(new Product("B2", "Juice", 30), 5);
        
        // Set initial state
        currentState = idleState;
        insertedMoney = 0;
    }
    
    public void addProduct(Product product, int quantity) {
        inventory.put(product.getCode(), product);
        stock.put(product.getCode(), quantity);
    }
    
    public void insertMoney(int amount) {
        currentState.insertMoney(amount);
    }
    
    public void selectProduct(String productCode) {
        currentState.selectProduct(productCode);
    }
    
    public void dispenseProduct() {
        currentState.dispenseProduct();
    }
    
    public void cancelTransaction() {
        currentState.cancelTransaction();
    }
    
    public void refillProducts() {
        currentState.refillProducts();
    }
    
    // State management
    public void setState(VendingMachineState state) {
        this.currentState = state;
    }
    
    // Getters for state objects
    public VendingMachineState getIdleState() {
        return idleState;
    }
    
    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }
    
    public VendingMachineState getDispensingState() {
        return dispensingState;
    }
    
    public VendingMachineState getOutOfStockState() {
        return outOfStockState;
    }
    
    // Money management
    public void addMoney(int amount) {
        this.insertedMoney += amount;
    }
    
    public int getInsertedMoney() {
        return insertedMoney;
    }
    
    public void resetMoney() {
        this.insertedMoney = 0;
    }
    
    public int returnMoney() {
        int money = insertedMoney;
        insertedMoney = 0;
        return money;
    }
    
    // Product management
    public Product getProduct(String code) {
        return inventory.get(code);
    }
    
    public boolean isProductAvailable(String code) {
        return stock.containsKey(code) && stock.get(code) > 0;
    }
    
    public void reduceStock(String code) {
        if (stock.containsKey(code)) {
            stock.put(code, stock.get(code) - 1);
        }
    }
    
    public void setSelectedProduct(Product product) {
        this.selectedProduct = product;
    }
    
    public Product getSelectedProduct() {
        return selectedProduct;
    }
    
    public void resetSelectedProduct() {
        this.selectedProduct = null;
    }
    
    public boolean hasAnyStock() {
        return stock.values().stream().anyMatch(quantity -> quantity > 0);
    }
    
    public void refillAllProducts() {
        for (String code : stock.keySet()) {
            stock.put(code, 10); // Refill to 10 items each
        }
    }
    
    public void displayInventory() {
        System.out.println("\n=== Vending Machine Inventory ===");
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            String code = entry.getKey();
            Product product = entry.getValue();
            int quantity = stock.get(code);
            System.out.println(code + ": " + product.getName() + " - $" + product.getPrice() + " (Stock: " + quantity + ")");
        }
        System.out.println("================================\n");
    }
}
