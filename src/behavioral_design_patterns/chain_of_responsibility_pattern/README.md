# Chain of Responsibility Pattern

## Overview
The Chain of Responsibility pattern passes requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain. This pattern decouples senders and receivers of requests and allows multiple objects to handle the request.

## Key Benefits
- **Decoupling**: The sender doesn't need to know which handler will process the request
- **Flexibility**: You can add or remove handlers dynamically at runtime
- **Single Responsibility**: Each handler focuses on one specific type of processing
- **Open/Closed Principle**: You can introduce new handlers without changing existing code

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/chain_of_responsibility_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.chain_of_responsibility_pattern.example.ChainOfResponsibilityPatternExample
   ```

## Example Structure

The example demonstrates a support ticket system where different levels of support staff handle tickets based on their priority:

### Files Structure:
```
behavioral_design_patterns/chain_of_responsibility_pattern/
├── example/
│   ├── SupportHandler.java - Abstract handler defining the chain interface
│   ├── Level1Support.java - Handles basic tickets (priority 1-3)
│   ├── Level2Support.java - Handles intermediate tickets (priority 4-6)
│   ├── Level3Support.java - Handles complex tickets (priority 7-10)
│   ├── SupportTicket.java - Request object containing ticket details
│   └── ChainOfResponsibilityPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Handler**: `SupportHandler` (abstract base class)
- **Concrete Handlers**: `Level1Support`, `Level2Support`, `Level3Support`
- **Request**: `SupportTicket` (contains ticket information)
- **Client**: `ChainOfResponsibilityPatternExample` (sets up chain and sends requests)

## Usage

```java
// Create handlers
SupportHandler level1 = new Level1Support();
SupportHandler level2 = new Level2Support();
SupportHandler level3 = new Level3Support();

// Build the chain: Level1 -> Level2 -> Level3
level1.setNextHandler(level2);
level2.setNextHandler(level3);

// Create and process tickets
SupportTicket ticket = new SupportTicket("Critical system failure", 9);
level1.handleTicket(ticket); // Will be handled by Level3Support
```

## When to Use

- When you want to give more than one object a chance to handle a request
- When you don't want to specify handlers explicitly in your code
- When the set of handlers should be specified dynamically
- When you want to issue a request to one of several objects without specifying the receiver explicitly
- When you want to decouple request senders from request receivers

## Real-World Examples

- HTTP request processing in web servers (middleware chains)
- Event bubbling in GUI frameworks
- Approval workflows in business applications
- Exception handling mechanisms
- Logging systems with different log levels