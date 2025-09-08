# Mediator Pattern

## Overview
The Mediator pattern defines how objects interact with each other without having direct references to each other. Instead of objects communicating directly, they communicate through a central mediator object. This reduces dependencies between communicating objects, thereby reducing coupling and making the system easier to maintain and extend.

## Key Benefits
- **Reduced Coupling**: Objects don't need direct references to each other
- **Centralized Control**: Communication logic is centralized in one place
- **Reusability**: Mediator can be reused with different sets of objects
- **Maintainability**: Easy to modify interaction behavior without changing individual objects
- **Extensibility**: New participant types can be added without modifying existing ones
- **Single Responsibility**: Each object focuses on its core functionality, not communication

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/mediator_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.mediator_pattern.example.MediatorPatternExample
   ```

## Example Structure

The example demonstrates a chat room application where different types of users communicate through chat rooms without knowing about each other directly:

### Files Structure:
```
behavioral_design_patterns/mediator_pattern/
├── example/
│   ├── ChatMediator.java - Mediator interface defining communication methods
│   ├── ChatRoom.java - Concrete mediator managing user interactions
│   ├── User.java - Abstract colleague class for chat participants
│   ├── RegularUser.java - Concrete colleague representing regular users
│   ├── PremiumUser.java - Concrete colleague with premium features
│   ├── AdminUser.java - Concrete colleague with administrative privileges
│   └── MediatorPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Mediator**: `ChatMediator` interface (defines communication protocol)
- **Concrete Mediator**: `ChatRoom` (coordinates communication between users)
- **Colleague**: `User` abstract class (defines user interface)
- **Concrete Colleagues**: `RegularUser`, `PremiumUser`, `AdminUser` (different user types)
- **Client**: `MediatorPatternExample` (creates and configures the system)

## Usage

```java
// Create mediator (chat room)
ChatRoom chatRoom = new ChatRoom("General Chat");

// Create users (colleagues)
RegularUser alice = new RegularUser(chatRoom, "Alice");
PremiumUser bob = new PremiumUser(chatRoom, "Bob");
AdminUser admin = new AdminUser(chatRoom, "Admin");

// Add users to chat room
chatRoom.addUser(alice);
chatRoom.addUser(bob);
chatRoom.addUser(admin);

// Users communicate through mediator
alice.send("Hello everyone!");
bob.send("Hi Alice!");
admin.sendSystemAnnouncement("Welcome to the chat!");

// Remove user from chat
chatRoom.removeUser(alice);
```

## When to Use

- When a set of objects communicate in well-defined but complex ways
- When reusing an object is difficult because it communicates with many other objects
- When you want to avoid tight coupling between interacting objects
- When you want to centralize complex communications and control logic
- When behavior distributed between several objects should be customizable without subclassing
- When you want to create reusable components that work in different contexts

## Real-World Examples

- Chat applications and messaging systems
- Air traffic control systems coordinating aircraft
- GUI dialog boxes where components interact through the dialog
- Workflow management systems
- Game lobbies managing player interactions
- Event bus systems in applications
- Auction systems coordinating bidders
- Social media platforms managing user interactions
- Online collaboration tools (like Slack, Discord)
- Trading platforms coordinating buyers and sellers

## Comparison with Observer Pattern

- **Observer**: One-to-many dependency where observers are notified of changes
- **Mediator**: Many-to-many communication where objects interact through a central hub
- **Observer**: Publishers don't know specific subscribers
- **Mediator**: Colleagues don't know each other, only the mediator