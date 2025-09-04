# Facade Pattern

## Overview

The Facade Pattern provides a simplified interface to a complex subsystem. It defines a higher-level interface that makes the subsystem easier to use by hiding its complexity from clients.

## Structure

- **CPU**, **Memory**, **HardDrive**, **GraphicsCard** (Subsystem Classes): Complex subsystem components with detailed operations
- **ComputerFacade** (Facade): Provides a simple interface to the complex computer startup process

## Key Benefits

- **Simplicity**: Provides a simple interface to complex subsystems
- **Decoupling**: Reduces dependencies between clients and subsystems
- **Layered Architecture**: Creates clear layers in the system architecture
- **Ease of Use**: Makes complex systems more accessible to clients

## Example Usage

The computer system example demonstrates how the facade:
- Hides the complexity of computer startup from the client
- Coordinates multiple subsystems (CPU, Memory, HardDrive, GraphicsCard)
- Provides simple `start()` and `shutdown()` methods
- Handles the correct sequence of operations internally

## Without Facade vs With Facade

**Without Facade**: Client must know about all subsystems and their interaction order
**With Facade**: Client only needs to know about the facade's simple interface

## Running the Example

```bash
javac structural_design_patterns/facade_pattern/example/*.java
java structural_design_patterns.facade_pattern.example.FacadePatternExample
```