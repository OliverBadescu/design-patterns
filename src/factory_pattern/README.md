# Factory Design Pattern

## Overview

The Factory Pattern is a creational design pattern that provides an interface for creating objects without specifying their exact classes. It encapsulates object creation logic and allows the system to be independent of how objects are created, composed, and represented.

## Key Benefits

- **Loose Coupling**: Client code doesn't need to know the concrete classes
- **Flexibility**: Easy to add new product types without modifying existing code
- **Single Responsibility**: Object creation logic is centralized in one place
- **Open/Closed Principle**: Open for extension, closed for modification

## How to Run the Example

1. Navigate to the src directory (parent of factory_pattern):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac factory_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java factory_pattern.example.VehicleExample
   ```

## Example Structure

The example demonstrates a Vehicle Factory that creates different types of vehicles:

### Files Structure:
```
factory_pattern/
├── example/
│   ├── Vehicle.java - Abstract base class defining the vehicle interface
│   ├── Car.java - Concrete implementation for cars
│   ├── Motorcycle.java - Concrete implementation for motorcycles  
│   ├── Truck.java - Concrete implementation for trucks
│   ├── VehicleFactory.java - Factory class with createVehicle() method
│   └── VehicleExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Abstract Product**: `Vehicle` (abstract base class)
- **Concrete Products**: `Car`, `Motorcycle`, `Truck`
- **Factory**: `VehicleFactory` with `createVehicle()` method

## Usage

```java
// Create different vehicles using the factory
Vehicle car = VehicleFactory.createVehicle("car");
Vehicle motorcycle = VehicleFactory.createVehicle("motorcycle");
Vehicle truck = VehicleFactory.createVehicle("truck");

// Use the vehicles
System.out.println(car.getInfo());          // "This is a car"
System.out.println(motorcycle.startEngine()); // "Motorcycle engine started"
```

## When to Use

- When you need to create objects without knowing their exact types beforehand
- When the creation process is complex and should be centralized
- When you want to decouple object creation from object usage
- When you need to support multiple product families