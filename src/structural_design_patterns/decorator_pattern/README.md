# Decorator Pattern

## Overview

The Decorator Pattern allows behavior to be added to objects dynamically without altering their structure. It provides a flexible alternative to subclassing for extending functionality.

## Structure

- **Coffee** (Component Interface): Defines the interface for objects that can have responsibilities added to them dynamically
- **SimpleCoffee** (Concrete Component): Defines an object to which additional responsibilities can be attached
- **CoffeeDecorator** (Decorator): Maintains a reference to a Component object and defines an interface that conforms to Component's interface
- **MilkDecorator**, **SugarDecorator**, **WhippedCreamDecorator** (Concrete Decorators): Add responsibilities to the component

## Key Benefits

- **Flexibility**: Add or remove responsibilities from objects at runtime
- **Composition over inheritance**: Extend functionality without creating multiple subclasses
- **Single Responsibility**: Each decorator handles one specific enhancement
- **Open/Closed Principle**: Open for extension, closed for modification

## Example Usage

The coffee shop example demonstrates how you can:
- Start with a simple coffee
- Dynamically add ingredients (milk, sugar, whipped cream)
- Stack multiple decorators
- Calculate total cost based on added decorators

## Running the Example

```bash
javac structural_design_patterns/decorator_pattern/example/*.java
java structural_design_patterns.decorator_pattern.example.DecoratorPatternExample
```