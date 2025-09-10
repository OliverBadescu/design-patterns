# Template Method Pattern

## Overview
The Template Method pattern defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure. This pattern is particularly useful when you have multiple classes that follow the same sequence of steps, but each step needs to be implemented differently based on the specific context.

## Key Benefits
- **Algorithm Structure**: Defines a common algorithm structure that all subclasses follow
- **Code Reuse**: Common steps are implemented once in the base class
- **Prevents Duplication**: Eliminates duplicate code across similar implementations
- **Enforces Structure**: Ensures all subclasses follow the same workflow
- **Flexibility**: Allows customization of specific steps without changing the overall flow
- **Template Control**: Base class controls the algorithm's structure and flow

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/template_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.template_pattern.example.TemplatePatternExample
   ```

## Example Structure

The example demonstrates a data processing system that handles different file formats (CSV, XML, JSON) using the same workflow:

### Files Structure:
```
behavioral_design_patterns/template_pattern/
├── example/
│   ├── DataProcessor.java - Abstract template class defining the processing workflow
│   ├── CSVDataProcessor.java - Concrete implementation for CSV file processing
│   ├── XMLDataProcessor.java - Concrete implementation for XML file processing
│   ├── JSONDataProcessor.java - Concrete implementation for JSON file processing
│   └── TemplatePatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Abstract Class**: `DataProcessor` (defines the template method and abstract steps)
- **Template Method**: `processData()` (defines the algorithm skeleton)
- **Abstract Methods**: `loadData()`, `validateData()`, `transformData()`, `saveData()` (steps implemented by subclasses)
- **Hook Method**: `cleanup()` (optional step with default implementation)
- **Concrete Classes**: `CSVDataProcessor`, `XMLDataProcessor`, `JSONDataProcessor` (implement specific steps)

## Usage

```java
// Using CSV processor
DataProcessor csvProcessor = new CSVDataProcessor("users.csv");
csvProcessor.processData(); // Executes: load → validate → transform → save → cleanup

// Using XML processor  
DataProcessor xmlProcessor = new XMLDataProcessor("users.xml");
xmlProcessor.processData(); // Same workflow, different implementations

// Using JSON processor
DataProcessor jsonProcessor = new JSONDataProcessor("users.json");
jsonProcessor.processData(); // Same workflow, JSON-specific logic
```

## When to Use

- When you have multiple classes that implement similar algorithms with the same steps
- When you want to avoid code duplication in algorithms that have common structure
- When you need to control the sequence of algorithm steps from a central location
- When you want to allow subclasses to customize specific parts of an algorithm
- When you have a multi-step process where some steps are common and others vary
- When you want to enforce a specific workflow or protocol across implementations

## Real-World Examples

- Data processing pipelines (ETL: Extract, Transform, Load with different data sources)
- Web request handling (authenticate, validate, process, respond)
- Game AI behavior (sense, think, act cycle with different AI types)
- Software build processes (compile, test, package, deploy with different targets)
- Document generation (load template, populate data, format, export)
- Authentication workflows (validate credentials, check permissions, log access)
- Database operations (connect, validate, execute, cleanup)
- Image processing (load, apply filters, optimize, save)
- Report generation (gather data, format, apply styling, output)
- Email sending (compose, validate, authenticate, send, log)

## Comparison with Other Patterns

### Template Method vs Strategy
- **Template Method**: Uses inheritance to vary parts of an algorithm
- **Strategy**: Uses composition to vary entire algorithms
- **Template Method**: Algorithm structure is fixed, only specific steps vary
- **Strategy**: Entire algorithm can be replaced at runtime

### Template Method vs Factory Method
- **Template Method**: Defines algorithm structure with varying steps
- **Factory Method**: Defines object creation with varying product types
- **Template Method**: Focuses on behavioral algorithms and workflows
- **Factory Method**: Focuses on object instantiation and creation

### Template Method vs State
- **Template Method**: Algorithm steps vary based on subclass implementation
- **State**: Object behavior changes based on internal state
- **Template Method**: Structure is defined at compile time through inheritance
- **State**: Behavior changes at runtime through state transitions

## Hook Methods

The Template Method pattern often includes hook methods - methods that provide default behavior but can be overridden by subclasses:

```java
// In the abstract class
protected void cleanup() {
    // Default implementation - can be overridden if needed
    System.out.println("Performing cleanup operations...");
}
```

Hook methods provide extension points without forcing all subclasses to implement them, offering more flexibility in the template structure.