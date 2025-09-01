# Builder Design Pattern

## Overview

The Builder Pattern is a creational design pattern that constructs complex objects step by step. It allows you to create different types and representations of an object using the same construction code. This pattern is particularly useful when an object needs to be created with many optional parameters.

## Key Benefits

- **Flexibility**: Allows creating objects with different configurations using the same process
- **Readability**: Method chaining makes object creation more readable than constructors with many parameters
- **Immutability**: Objects can be made immutable after construction
- **Validation**: Construction process can include validation logic
- **Optional Parameters**: Handles objects with many optional parameters elegantly

## How to Run the Example

1. Navigate to the src directory (parent of creational_design_patterns.builder_pattern):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac creational_design_patterns.builder_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java creational_design_patterns.builder_pattern.example.BuilderPatternExample
   ```

## Example Structure

The example demonstrates a Computer Builder that constructs computers with various specifications:

### Files Structure:
```
creational_design_patterns.builder_pattern/
├── example/
│   ├── Computer.java - Product class with nested ComputerBuilder
│   ├── ComputerDirector.java - Director class with predefined build methods
│   └── BuilderPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Product**: `Computer` (the complex object being built)
- **Builder**: `Computer.ComputerBuilder` (constructs the product step by step)
- **Director**: `ComputerDirector` (optional, provides predefined construction processes)

## Usage

### Basic Builder Usage:
```java
Computer computer = new Computer.ComputerBuilder("Intel i7", "16GB")
    .setStorage("512GB SSD")
    .setGraphicsCard("NVIDIA GTX 1660")
    .enableWiFi()
    .build();
```

### Using Director for Predefined Configurations:
```java
Computer gamingPC = ComputerDirector.buildGamingComputer();
Computer officePC = ComputerDirector.buildOfficeComputer();
```

### Minimal Configuration:
```java
Computer basicPC = new Computer.ComputerBuilder("AMD Ryzen 5", "8GB")
    .build(); // Uses default values for optional components
```

## When to Use

- When creating objects with many optional parameters (avoids telescoping constructor problem)
- When you need different representations of the same object
- When the construction process should be independent of the parts that make up the object
- When you want to ensure objects are fully constructed before use
- When object creation is complex and requires step-by-step construction

## Advantages over Constructor

Instead of:
```java
// Confusing constructor with many parameters
Computer pc = new Computer("Intel i7", "16GB", "512GB SSD", "GTX 1660", "650W", true, false);
```

Use Builder:
```java
// Clear, readable builder pattern
Computer pc = new Computer.ComputerBuilder("Intel i7", "16GB")
    .setStorage("512GB SSD")
    .setGraphicsCard("GTX 1660")
    .setPowerSupply("650W")
    .enableWiFi()
    .build();
```