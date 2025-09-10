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

## Structural Design Patterns

Structural patterns deal with object composition, creating relationships between objects to form larger structures.

### 1. [Adapter Pattern](src/structural_design_patterns/adapter_pattern/README.md)
Allows incompatible interfaces to work together by creating a wrapper that converts one interface to another.

**Example**: Audio player system that can play different media formats through adapters.

### 2. [Bridge Pattern](src/structural_design_patterns/bridge_pattern/README.md)
Separates abstraction from implementation, allowing both to vary independently.

**Example**: Shape rendering system with different renderers (Vector, Raster) for various shapes.

### 3. [Composite Pattern](src/structural_design_patterns/composite_pattern/README.md)
Composes objects into tree structures to represent part-whole hierarchies, treating individual and composite objects uniformly.

**Example**: File system hierarchy with files and directories.

### 4. [Decorator Pattern](src/structural_design_patterns/decorator_pattern/README.md)
Dynamically adds new functionality to objects without altering their structure by wrapping them in decorator objects.

**Example**: Coffee ordering system where you can add various ingredients to customize your coffee.

### 5. [Facade Pattern](src/structural_design_patterns/facade_pattern/README.md)
Provides a simplified interface to a complex subsystem, making it easier to use.

**Example**: Computer startup system that coordinates CPU, memory, graphics card, and hard drive.

### 6. [Flyweight Pattern](src/structural_design_patterns/flyweight_pattern/README.md)
Minimizes memory usage by sharing efficiently common data among multiple objects.

**Example**: Forest rendering system that shares tree type data among many tree instances.

### 7. [Proxy Pattern](src/structural_design_patterns/proxy_pattern/README.md)
Provides a placeholder or surrogate for another object to control access to it.

**Example**: Image loading system with lazy loading and caching functionality.

## Behavioral Design Patterns

Behavioral patterns focus on communication between objects and the assignment of responsibilities between objects.

### 1. [Chain of Responsibility Pattern](src/behavioral_design_patterns/chain_of_responsibility_pattern/README.md)
Passes requests along a chain of handlers, where each handler decides either to process the request or pass it to the next handler.

**Example**: Support ticket system where different support levels handle tickets based on priority.

### 2. [Command Pattern](src/behavioral_design_patterns/command_pattern/README.md)
Turns requests into stand-alone objects containing all information about the request, allowing parameterization, queuing, and undo operations.

**Example**: Smart home automation system with remote control that can execute, undo, and group commands into macros.

### 3. [Iterator Pattern](src/behavioral_design_patterns/iterator_pattern/README.md)
Provides a way to access elements of a collection sequentially without exposing its underlying representation.

**Example**: Library management system with different iterators for browsing all books, books by genre, or books by author.

### 4. [Mediator Pattern](src/behavioral_design_patterns/mediator_pattern/README.md)
Defines how objects interact with each other without having direct references, reducing coupling by centralizing communication through a mediator.

**Example**: Chat room application where users communicate through the chat room mediator without knowing about each other directly.

### 5. [Memento Pattern](src/behavioral_design_patterns/memento_pattern/README.md)
Provides the ability to restore an object to its previous state without violating encapsulation, commonly used for undo/redo functionality.

**Example**: Text editor with comprehensive undo/redo functionality that preserves both content and cursor position.

### 6. [Observer Pattern](src/behavioral_design_patterns/observer_pattern/README.md)
Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

**Example**: Weather monitoring system where multiple displays automatically update when weather conditions change.

### 7. [State Pattern](src/behavioral_design_patterns/state_pattern/README.md)
Allows an object to alter its behavior when its internal state changes, appearing to change its class. Encapsulates state-specific behavior into separate classes.

**Example**: Vending machine that changes behavior based on current state (No Coin, Has Coin, Sold, Out of Stock).

### 8. [Strategy Pattern](src/behavioral_design_patterns/strategy_pattern/README.md)
Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

**Example**: E-commerce shopping cart system that supports multiple payment methods (Credit Card, PayPal, Cryptocurrency, Bank Transfer).

### 9. [Template Method Pattern](src/behavioral_design_patterns/template_pattern/README.md)
Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

**Example**: Data processing system that handles different file formats (CSV, XML, JSON) using the same workflow (load → validate → transform → save → cleanup).

### 10. [Visitor Pattern](src/behavioral_design_patterns/visitor_pattern/README.md)
Allows you to define new operations on a set of objects without changing the classes of the objects themselves. Separates algorithms from the object structure they operate on.

**Example**: Shape processing system that performs different operations (drawing, area calculation, perimeter calculation) on various shapes without modifying the shape classes.
