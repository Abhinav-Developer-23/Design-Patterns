# Vending Machine State Pattern - Class Diagram

## UML Class Diagram (Text Representation)

```
┌──────────────────────────┐
│  VendingMachineState     │
│      <<interface>>       │
├──────────────────────────┤
│ + insertMoney(int)       │
│ + selectProduct(String)  │
│ + dispenseProduct()      │
│ + cancelTransaction()    │
│ + refillProducts()       │
└──────────────────────────┘
           △
           │ implements
    ┌──────┴──────┬──────────────┬────────────────┐
    │             │              │                │
┌───┴────────┐ ┌──┴───────────┐ ┌┴──────────────┐ ┌┴────────────────┐
│ IdleState  │ │ HasMoneyState│ │DispensingState│ │OutOfStockState  │
├────────────┤ ├──────────────┤ ├───────────────┤ ├─────────────────┤
│-machine    │ │-machine      │ │-machine       │ │-machine         │
└────────────┘ └──────────────┘ └───────────────┘ └─────────────────┘
       │                │               │                  │
       └────────────────┴───────────────┴──────────────────┘
                                │
                         uses (context)
                                │
                                ▼
                    ┌───────────────────────────┐
                    │    VendingMachine         │
                    │      (Context)            │
                    ├───────────────────────────┤
                    │ - currentState            │
                    │ - idleState               │
                    │ - hasMoneyState           │
                    │ - dispensingState         │
                    │ - outOfStockState         │
                    │ - inventory               │
                    │ - stock                   │
                    │ - insertedMoney           │
                    │ - selectedProduct         │
                    ├───────────────────────────┤
                    │ + insertMoney(int)        │
                    │ + selectProduct(String)   │
                    │ + dispenseProduct()       │
                    │ + cancelTransaction()     │
                    │ + refillProducts()        │
                    │ + setState(State)         │
                    │ + getProduct(String)      │
                    │ + isProductAvailable()    │
                    │ + addMoney(int)           │
                    │ + returnMoney()           │
                    └───────────────────────────┘
                                │
                                │ manages
                                ▼
                    ┌───────────────────────────┐
                    │       Product             │
                    ├───────────────────────────┤
                    │ - code: String            │
                    │ - name: String            │
                    │ - price: int              │
                    ├───────────────────────────┤
                    │ + getCode()               │
                    │ + getName()               │
                    │ + getPrice()              │
                    └───────────────────────────┘
```

## Component Relationships

### 1. State Interface
- **VendingMachineState**: Defines contract for all states

### 2. Concrete State Implementations
- **IdleState**: Initial state, waiting for money
- **HasMoneyState**: Money inserted, waiting for selection
- **DispensingState**: Currently dispensing product
- **OutOfStockState**: No products available

### 3. Context
- **VendingMachine**: Maintains current state and delegates operations

### 4. Model
- **Product**: Represents items in the vending machine

## State Transition Flow

```
     [Idle State]
          │
          │ insertMoney()
          ▼
    [HasMoney State]
          │
          │ selectProduct() + valid selection
          ▼
   [Dispensing State]
          │
          ├─ if stock > 0 ──────► [Idle State]
          │
          └─ if stock == 0 ─────► [OutOfStock State]
                                       │
                                       │ refillProducts()
                                       ▼
                                  [Idle State]
```

## Design Pattern Benefits

1. **Encapsulation**: Each state encapsulates its own behavior
2. **Maintainability**: Easy to modify individual state behaviors
3. **Extensibility**: New states can be added without changing existing code
4. **Clarity**: State transitions are explicit and clear
5. **Single Responsibility**: Each class has one reason to change

## Key Methods by State

| State | insertMoney | selectProduct | dispenseProduct | cancelTransaction | refillProducts |
|-------|-------------|---------------|-----------------|-------------------|----------------|
| **Idle** | ✓ → HasMoney | ✗ Error | ✗ Error | ✗ No transaction | ✓ Refill |
| **HasMoney** | ✓ Add more | ✓ → Dispensing | ✗ Error | ✓ → Idle | ✗ Error |
| **Dispensing** | ✗ Wait | ✗ Wait | ✓ → Idle/OutOfStock | ✗ Cannot cancel | ✗ Wait |
| **OutOfStock** | ✗ Error | ✗ Error | ✗ Error | ✗ No transaction | ✓ → Idle |

✓ = Allowed operation  
✗ = Operation rejected/error  
→ = State transition
