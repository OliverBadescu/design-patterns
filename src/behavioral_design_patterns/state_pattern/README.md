# State Pattern

## Overview
The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. This pattern is particularly useful when you have an object that needs to behave differently based on its internal state, and you want to avoid large conditional statements. It encapsulates state-specific behavior into separate classes and delegates state-dependent operations to the current state object.

## Key Benefits
- **Eliminates Complex Conditionals**: Replaces large if/else or switch statements with polymorphism
- **Localizes State-Specific Behavior**: Each state's behavior is contained within its own class
- **Makes State Transitions Explicit**: State changes are clearly defined and controlled
- **Easy to Add New States**: Adding new states doesn't require modifying existing code
- **Follows Single Responsibility Principle**: Each state class has a single responsibility
- **Improves Maintainability**: State-specific logic is organized and easier to maintain

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/state_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.state_pattern.example.StatePatternExample
   ```

## Example Structure

The example demonstrates a vending machine that changes its behavior based on its current state (No Coin, Has Coin, Sold, Out of Stock):

### Files Structure:
```
behavioral_design_patterns/state_pattern/
├── example/
│   ├── State.java - State interface defining state-specific operations
│   ├── VendingMachine.java - Context class that maintains current state
│   ├── NoCoinState.java - State when no coin is inserted
│   ├── HasCoinState.java - State when coin is inserted but no product selected
│   ├── SoldState.java - State during product dispensing
│   ├── OutOfStockState.java - State when machine is out of products
│   └── StatePatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **State**: `State` interface (defines operations that can be performed in different states)
- **Context**: `VendingMachine` (maintains reference to current state and delegates operations)
- **Concrete States**: `NoCoinState`, `HasCoinState`, `SoldState`, `OutOfStockState` (implement state-specific behavior)
- **Client**: `StatePatternExample` (interacts with the context and demonstrates state transitions)

## Usage

```java
// Create vending machine with initial products
VendingMachine vendingMachine = new VendingMachine(5);

// Normal purchase flow - states change automatically
vendingMachine.insertCoin();      // NoCoinState -> HasCoinState
vendingMachine.selectProduct("Coke"); // HasCoinState -> SoldState
vendingMachine.dispenseProduct();  // SoldState -> NoCoinState (or OutOfStockState if empty)

// Each state handles operations differently
vendingMachine.selectProduct("Pepsi"); // NoCoinState: "Please insert coin first"
vendingMachine.insertCoin();           // NoCoinState -> HasCoinState
vendingMachine.ejectCoin();            // HasCoinState -> NoCoinState
```

## When to Use

- When an object's behavior depends on its state and it must change its behavior at runtime
- When you have complex conditional statements that depend on the object's state
- When state-specific behavior is likely to change or expand over time
- When you want to avoid duplicating similar conditional logic across multiple methods
- When implementing finite state machines or workflow systems
- When you need to ensure valid state transitions and prevent invalid operations

## Real-World Examples

- Vending machines (different states: no coin, has coin, dispensing, out of stock)
- TCP connection states (closed, listening, established, closing)
- Game character states (idle, walking, running, jumping, attacking)
- Document workflow systems (draft, review, approved, published)
- Media players (stopped, playing, paused, buffering)
- Order processing systems (pending, confirmed, shipped, delivered)
- Authentication systems (logged out, logging in, logged in, session expired)
- Traffic light controllers (red, yellow, green states)
- ATM machines (idle, card inserted, PIN entered, transaction in progress)
- Elevator control systems (idle, moving up, moving down, doors opening)

## Comparison with Other Patterns

### State vs Strategy
- **State**: Object's behavior changes based on internal state; state transitions occur automatically
- **Strategy**: Behavior is chosen by the client; no automatic transitions between strategies
- **State**: States often know about other states and can trigger transitions
- **Strategy**: Strategies are typically independent of each other

### State vs Command
- **State**: Encapsulates behavior based on object's state
- **Command**: Encapsulates requests as objects for parameterization and queuing
- **State**: Changes behavior of the context object
- **Command**: Executes operations but doesn't change the invoker's behavior