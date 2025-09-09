# Strategy Pattern

## Overview
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it. This pattern is particularly useful when you have multiple ways of performing a task and want to be able to choose the approach at runtime without using conditional statements.

## Key Benefits
- **Algorithm Flexibility**: Multiple algorithms can be used interchangeably
- **Runtime Selection**: Algorithm choice can be made at runtime based on context
- **Easy Extension**: New algorithms can be added without modifying existing code
- **Eliminates Conditionals**: Removes large if/else or switch statements
- **Open/Closed Principle**: Open for extension, closed for modification
- **Single Responsibility**: Each strategy focuses on one specific algorithm

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/strategy_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.strategy_pattern.example.StrategyPatternExample
   ```

## Example Structure

The example demonstrates an e-commerce shopping cart system that supports multiple payment methods (Credit Card, PayPal, Cryptocurrency, Bank Transfer):

### Files Structure:
```
behavioral_design_patterns/strategy_pattern/
├── example/
│   ├── PaymentStrategy.java - Strategy interface defining payment operations
│   ├── CreditCardPayment.java - Concrete strategy for credit card payments
│   ├── PayPalPayment.java - Concrete strategy for PayPal payments
│   ├── CryptocurrencyPayment.java - Concrete strategy for crypto payments
│   ├── BankTransferPayment.java - Concrete strategy for bank transfers
│   ├── ShoppingCart.java - Context class that uses payment strategies
│   ├── Item.java - Data class representing cart items
│   └── StrategyPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Strategy**: `PaymentStrategy` interface (defines common operations for all payment methods)
- **Context**: `ShoppingCart` (maintains reference to strategy and delegates payment processing)
- **Concrete Strategies**: `CreditCardPayment`, `PayPalPayment`, `CryptocurrencyPayment`, `BankTransferPayment` (implement specific payment algorithms)
- **Client**: `StrategyPatternExample` (configures context with appropriate strategy)

## Usage

```java
// Create shopping cart (context)
ShoppingCart cart = new ShoppingCart();

// Add items to cart
cart.addItem(new Item("Laptop", 999.99, "Electronics"));
cart.addItem(new Item("Mouse", 29.99, "Electronics"));

// Choose payment strategy at runtime
PaymentStrategy creditCard = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/25");
cart.setPaymentStrategy(creditCard);

// Process payment using selected strategy
cart.checkout();

// Switch to different strategy
PaymentStrategy paypal = new PayPalPayment("john@email.com", "password");
cart.setPaymentStrategy(paypal);
cart.checkout();
```

## When to Use

- When you have multiple ways to perform a task and want to choose the approach at runtime
- When you want to avoid large conditional statements that select different behaviors
- When you need to isolate algorithm implementations from the code that uses them
- When you want to add new algorithms without modifying existing client code
- When algorithms might change frequently or new variants are expected
- When you want to make algorithms reusable across different contexts

## Real-World Examples

- Payment processing systems (credit card, PayPal, cryptocurrency, bank transfer)
- Sorting algorithms (quick sort, merge sort, bubble sort based on data size)
- Compression algorithms (ZIP, RAR, 7-Zip based on file type or size)
- Routing algorithms (shortest path, fastest route, scenic route in GPS systems)
- Authentication methods (OAuth, LDAP, database, social login)
- File export formats (PDF, Excel, CSV, XML based on user preference)
- Image processing filters (blur, sharpen, contrast, brightness)
- Data validation rules (email, phone, credit card, custom formats)
- Discount calculation strategies (percentage, fixed amount, bulk discount)
- Search algorithms (linear, binary, hash-based depending on data structure)

## Comparison with Other Patterns

### Strategy vs State
- **Strategy**: Algorithms are chosen by the client; no automatic transitions
- **State**: Object's behavior changes based on internal state; automatic state transitions
- **Strategy**: Strategies are typically independent of each other
- **State**: States often know about other states and trigger transitions

### Strategy vs Template Method
- **Strategy**: Uses composition and delegation to vary algorithms
- **Template Method**: Uses inheritance to vary parts of an algorithm
- **Strategy**: Entire algorithm can be replaced
- **Template Method**: Only specific steps of algorithm can be customized

### Strategy vs Command
- **Strategy**: Encapsulates algorithms and makes them interchangeable
- **Command**: Encapsulates requests as objects for parameterization and queuing
- **Strategy**: Focuses on how something is done (algorithm)
- **Command**: Focuses on what should be done (action/request)