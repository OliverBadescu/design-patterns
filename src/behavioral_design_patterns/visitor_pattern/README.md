# Visitor Pattern

## Overview
The Visitor pattern allows you to define new operations on a set of objects without changing the classes of the objects themselves. It separates algorithms from the object structure they operate on, making it easy to add new operations while keeping the object structure stable. This pattern is particularly useful when you have a stable set of classes but need to perform various unrelated operations on them.

## Key Benefits
- **Separation of Concerns**: Separates operations from object structure
- **Easy Extension**: New operations can be added without modifying existing classes
- **Single Responsibility**: Each visitor focuses on one specific operation
- **Type Safety**: Compile-time checking ensures all types are handled
- **Centralized Operations**: Related operations are grouped in one visitor class
- **Open/Closed Principle**: Open for extension (new visitors), closed for modification

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/visitor_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.visitor_pattern.example.VisitorPatternExample
   ```

## Example Structure

The example demonstrates a shape processing system that performs different operations (drawing, area calculation, perimeter calculation) on various shapes (Circle, Rectangle, Triangle) without modifying the shape classes:

### Files Structure:
```
behavioral_design_patterns/visitor_pattern/
├── example/
│   ├── ShapeVisitor.java - Visitor interface defining operations for all shape types
│   ├── Shape.java - Abstract element class with accept method
│   ├── Circle.java - Concrete element for circle shapes
│   ├── Rectangle.java - Concrete element for rectangle shapes
│   ├── Triangle.java - Concrete element for triangle shapes
│   ├── AreaCalculatorVisitor.java - Concrete visitor for area calculations
│   ├── PerimeterCalculatorVisitor.java - Concrete visitor for perimeter calculations
│   ├── DrawingVisitor.java - Concrete visitor for drawing operations
│   ├── ShapeCollection.java - Object structure holding shapes
│   └── VisitorPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Visitor Interface**: `ShapeVisitor` (declares visit methods for each element type)
- **Concrete Visitors**: `AreaCalculatorVisitor`, `PerimeterCalculatorVisitor`, `DrawingVisitor` (implement specific operations)
- **Element Interface**: `Shape` (declares accept method)
- **Concrete Elements**: `Circle`, `Rectangle`, `Triangle` (implement accept method and call appropriate visitor method)
- **Object Structure**: `ShapeCollection` (holds elements and provides iteration)

## Usage

```java
// Create shapes (elements)
ShapeCollection shapes = new ShapeCollection();
shapes.addShape(new Circle("Circle1", 5.0));
shapes.addShape(new Rectangle("Rect1", 10.0, 6.0));
shapes.addShape(new Triangle("Triangle1", 8.0, 6.0));

// Create visitors for different operations
AreaCalculatorVisitor areaVisitor = new AreaCalculatorVisitor();
DrawingVisitor drawingVisitor = new DrawingVisitor();

// Apply visitors to perform operations
shapes.acceptVisitor(areaVisitor);        // Calculate areas
shapes.acceptVisitor(drawingVisitor);     // Draw shapes

// Get results
double totalArea = areaVisitor.getTotalArea();

// Add new operations without modifying shape classes
ShapeVisitor customVisitor = new ShapeVisitor() {
    public void visit(Circle c) { /* custom logic */ }
    public void visit(Rectangle r) { /* custom logic */ }
    public void visit(Triangle t) { /* custom logic */ }
};
```

## When to Use

- When you have a stable set of classes but need to perform various unrelated operations on them
- When you want to add new operations without modifying existing class hierarchy
- When operations are unrelated to the core functionality of the objects
- When you have complex object structures and need to perform operations across all elements
- When you want to avoid polluting classes with many unrelated methods
- When operations change more frequently than the object structure

## Real-World Examples

- **Compiler Design**: AST (Abstract Syntax Tree) traversal for code generation, optimization, type checking
- **File System Operations**: Different operations on files/directories (backup, search, compress, analyze)
- **Document Processing**: Various operations on document elements (render, print, export, validate)
- **Game Engines**: Different behaviors on game objects (render, physics, AI, collision detection)
- **XML/DOM Processing**: Operations on XML nodes (validation, transformation, serialization)
- **Database Query Optimization**: Different optimization strategies on query tree nodes
- **Shopping Cart Systems**: Various operations on cart items (pricing, tax calculation, shipping)
- **Graphics Software**: Different tools operating on drawing elements (move, resize, color, effects)
- **Report Generation**: Different output formats for the same data structure
- **Code Analysis Tools**: Static analysis operations on code structures (complexity, dependencies, metrics)

## Comparison with Other Patterns

### Visitor vs Strategy
- **Visitor**: Operates on a hierarchy of different types, adds operations externally
- **Strategy**: Operates on a single type, encapsulates algorithms for the same operation
- **Visitor**: Uses double dispatch to select the right method for each type
- **Strategy**: Uses single dispatch based on strategy selection

### Visitor vs Command
- **Visitor**: Focuses on operations that traverse object structures
- **Command**: Encapsulates requests as objects for parameterization and queuing
- **Visitor**: Separates algorithms from object structure
- **Command**: Separates invoker from receiver of requests

### Visitor vs Iterator
- **Visitor**: Defines operations to perform on elements during traversal
- **Iterator**: Provides a way to access elements sequentially without exposing structure
- **Visitor**: Focus is on what operations to perform
- **Iterator**: Focus is on how to traverse the collection

## Double Dispatch

The Visitor pattern uses double dispatch - the operation executed depends on both the visitor type and the element type:

```java
// First dispatch: based on shape type (circle, rectangle, triangle)
shape.accept(visitor);

// Second dispatch: based on visitor type (area, perimeter, drawing)
visitor.visit(this);
```

This allows the correct method to be called based on both the runtime types of the visitor and the element.

## Adding New Operations

One of the main benefits is adding new operations without modifying existing classes:

```java
// New visitor for volume calculation (if shapes were 3D)
public class VolumeCalculatorVisitor implements ShapeVisitor {
    public void visit(Circle circle) {
        // Calculate sphere volume
    }
    public void visit(Rectangle rectangle) {
        // Calculate box volume  
    }
    public void visit(Triangle triangle) {
        // Calculate triangular prism volume
    }
}
```

## Limitations

- **Adding New Element Types**: Requires modifying all existing visitors
- **Circular Dependencies**: Visitors need to know about all element types
- **Breaking Encapsulation**: Visitors might need access to element internals
- **Complexity**: Can be overkill for simple operations or small hierarchies