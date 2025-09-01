# Singleton Pattern

## Overview
The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. This pattern is useful when exactly one object is needed to coordinate actions across the system.

## When to Use
- When you need exactly one instance of a class (e.g., database connection, logger, configuration manager)
- When you want to control access to a shared resource
- When you need a global point of access to an instance

## Implementation Details

### Thread-Safe Lazy Initialization
The example uses the double-checked locking pattern:
- `volatile` keyword ensures visibility across threads
- Synchronized block prevents multiple instances during concurrent access
- Double-checking minimizes synchronization overhead

### Key Components
1. **Private Constructor**: Prevents direct instantiation
2. **Static Instance Variable**: Holds the single instance
3. **Public Static Method**: Provides global access point
4. **Thread Safety**: Uses double-checked locking

## Example Structure
```
DatabaseConnection (Singleton)
├── instance (static volatile)
├── private constructor
├── getInstance() method
└── business methods
```

## Pros and Cons

### Pros
- Controlled access to single instance
- Reduced memory footprint
- Global access point
- Lazy initialization saves resources

### Cons
- Violates Single Responsibility Principle
- Can mask bad design
- Difficult to unit test
- Threading issues if not implemented properly

## Usage Example
```java
// Getting the singleton instance
DatabaseConnection db1 = DatabaseConnection.getInstance();
DatabaseConnection db2 = DatabaseConnection.getInstance();

// Both references point to the same instance
System.out.println(db1 == db2); // true
```

## Running the Example
```bash
javac src/singleton_pattern/example/*.java
java -cp src singleton_pattern.example.SingletonPatternExample
```