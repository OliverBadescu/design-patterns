# Abstract Factory Design Pattern

## Overview

The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It's essentially a factory of factories, ensuring that created objects work well together.

## Key Benefits

- **Consistency**: Ensures that products from the same family are used together
- **Loose Coupling**: Client code doesn't depend on concrete product classes
- **Flexibility**: Easy to switch between different product families
- **Single Responsibility**: Object creation logic is centralized and organized by family
- **Open/Closed Principle**: Open for extension with new families, closed for modification

## How to Run the Example

1. Navigate to the src directory (parent of abstract_factory_pattern):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac abstract_factory_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java abstract_factory_pattern.example.AbstractFactoryExample
   ```

## Example Structure

The example demonstrates a Vehicle Component Factory that creates families of compatible vehicle components:

### Files Structure:
```
abstract_factory_pattern/
├── example/
│   ├── Engine.java - Abstract base class for engines
│   ├── PetrolEngine.java - Concrete petrol engine implementation
│   ├── ElectricEngine.java - Concrete electric engine implementation
│   ├── Wheel.java - Abstract base class for wheels
│   ├── StandardWheel.java - Concrete standard wheel implementation
│   ├── SportWheel.java - Concrete sport wheel implementation
│   ├── VehicleComponentFactory.java - Abstract factory interface
│   ├── EconomyVehicleFactory.java - Factory for economy components
│   ├── LuxuryVehicleFactory.java - Factory for luxury components
│   └── AbstractFactoryExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Abstract Products**: `Engine`, `Wheel`
- **Concrete Products**: `PetrolEngine`, `ElectricEngine`, `StandardWheel`, `SportWheel`
- **Abstract Factory**: `VehicleComponentFactory`
- **Concrete Factories**: `EconomyVehicleFactory`, `LuxuryVehicleFactory`

## Usage

```java
VehicleComponentFactory economyFactory = new EconomyVehicleFactory();
VehicleComponentFactory luxuryFactory = new LuxuryVehicleFactory();

Engine economyEngine = economyFactory.createEngine();    
Wheel economyWheel = economyFactory.createWheel();     

Engine luxuryEngine = luxuryFactory.createEngine();      
Wheel luxuryWheel = luxuryFactory.createWheel();         
```

## When to Use

- When you need to create families of related objects that should be used together
- When you want to ensure compatibility between products from the same family
- When you need to support multiple product lines or variants
- When the system should be independent of how its products are created and composed
- When you want to provide a class library of products and only reveal their interfaces

## Difference from Factory Pattern

While the Factory Pattern creates single objects, the Abstract Factory Pattern creates families of related objects. It ensures that the created objects are compatible and work well together within their family.