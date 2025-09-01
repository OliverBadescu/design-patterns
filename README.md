# Design Patterns in Java

This repository contains implementations of various design patterns in Java, focusing on providing clear examples and explanations for each pattern.


Each pattern directory contains:
- `README.md` - Detailed explanation of the pattern
- `example/` - Java implementation with example usage

## Creational Design Patterns

Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

### 1. [Abstract Factory Pattern](src/creational_design_patterns/abstract_factory_pattern/README.md)
Creates families of related objects without specifying their concrete classes. Useful when you need to create multiple related products.

**Example**: Vehicle manufacturing system with different factories for luxury and economy vehicles.

### 2. [Builder Pattern](src/creational_design_patterns/builder_pattern/README.md)
Constructs complex objects step by step. Separates the construction process from the representation.

**Example**: Computer assembly system where you can build computers with different specifications.

### 3. [Factory Pattern](src/creational_design_patterns/factory_pattern/README.md)
Creates objects without specifying their exact class. Provides a common interface for creating objects of different types.

**Example**: Vehicle factory that creates cars, trucks, or motorcycles based on input parameters.

### 4. [Prototype Pattern](src/creational_design_patterns/prototype_pattern/README.md)
Creates objects by cloning existing instances. Useful when object creation is expensive or complex.

**Example**: Document management system that creates new documents by cloning existing templates.

### 5. [Singleton Pattern](src/creational_design_patterns/singleton_pattern/README.md)
Ensures a class has only one instance and provides global access to it. Commonly used for database connections, loggers, and configuration managers.

**Example**: Database connection manager that maintains a single connection instance.


## Pattern Categories

Currently implemented:
- ✅ **Creational Patterns** (5/5 common patterns)
- 🚧 **Structural Patterns** (Coming soon)
- 🚧 **Behavioral Patterns** (Coming soon)