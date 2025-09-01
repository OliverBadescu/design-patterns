# Bridge Design Pattern

## Overview

The Bridge Pattern is a structural design pattern that separates an abstraction from its implementation so that both can be developed independently. It uses composition instead of inheritance to connect different class hierarchies. The pattern creates a bridge structure that acts as an interface between the abstraction and its implementation.

## Key Benefits

- **Decoupling**: Separates interface from implementation, allowing both to vary independently
- **Runtime Binding**: Implementation can be selected and even switched at runtime
- **Extensibility**: New abstractions and implementations can be added without affecting existing code
- **Platform Independence**: Abstractions can work with multiple platform-specific implementations

## How to Run the Example

1. Navigate to the src directory (parent of structural_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac structural_design_patterns/bridge_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java structural_design_patterns.bridge_pattern.example.BridgePatternExample
   ```

## Example Structure

The example demonstrates a drawing application where shapes (Circle, Square, Triangle) can be rendered using different rendering engines (Vector, Raster):

### Files Structure:
```
structural_design_patterns/bridge_pattern/
├── example/
│   ├── Renderer.java - Implementation interface (the bridge)
│   ├── VectorRenderer.java - Concrete implementation for vector rendering
│   ├── RasterRenderer.java - Concrete implementation for raster rendering
│   ├── Shape.java - Abstract class representing the abstraction
│   ├── Circle.java - Refined abstraction for circles
│   ├── Square.java - Refined abstraction for squares
│   ├── Triangle.java - Refined abstraction for triangles
│   └── BridgePatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Abstraction**: `Shape` (defines the interface for shapes)
- **Refined Abstractions**: `Circle`, `Square`, `Triangle` (specific shape implementations)
- **Implementation**: `Renderer` (the bridge interface)
- **Concrete Implementations**: `VectorRenderer`, `RasterRenderer` (specific rendering implementations)

## Usage

```java
// Create different renderers
Renderer vectorRenderer = new VectorRenderer();
Renderer rasterRenderer = new RasterRenderer();

// Create shapes with different renderers
Shape circle = new Circle(vectorRenderer, 5, 10, 3);
Shape square = new Square(rasterRenderer, 0, 0, 4);

// Draw shapes - they will use their respective renderers
circle.draw();  // Uses vector rendering
square.draw();  // Uses raster rendering

// Resize shapes
circle.resize(1.5);
circle.draw();  // Still uses vector rendering with new size
```

## When to Use

- When you want to avoid permanent binding between an abstraction and implementation
- When both abstractions and implementations should be extensible through inheritance
- When implementation details should be hidden from clients
- When you have multiple platform-specific implementations
- When changes in implementation shouldn't impact client code

## Real-World Examples

- Graphics rendering systems (different rendering APIs for the same shapes)
- Database drivers (same database operations across different database engines)
- GUI frameworks (same widgets rendered differently on different operating systems)
- Media players (same media controls with different audio/video codecs)
- Communication protocols (same message format over different transport layers)

## Bridge vs Adapter

**Bridge**: Designed upfront to let abstraction and implementation vary independently
**Adapter**: Applied retroactively to make unrelated classes work together