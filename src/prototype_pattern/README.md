# Prototype Pattern

## Overview

The Prototype pattern is a creational design pattern that allows you to create new objects by cloning existing instances (prototypes) rather than creating them from scratch. This is particularly useful when object creation is expensive or when you need to create many similar objects with slight variations.

## Key Components

1. **Prototype Interface** (`Document`): Declares the cloning method
2. **Concrete Prototypes** (`TextDocument`, `PDFDocument`): Implement the cloning method
3. **Client/Registry** (`DocumentManager`): Manages prototypes and creates clones

## When to Use

- Object creation is expensive (complex initialization, database calls, etc.)
- You need to create objects that are similar to existing ones
- You want to avoid subclassing just for object creation
- Runtime object composition is preferred over compile-time class composition

## Example Structure

```
Document (abstract)
├── TextDocument
└── PDFDocument

DocumentManager (registry)
PrototypePatternExample (demo)
```

## How It Works

1. **DocumentManager** maintains a registry of prototype instances
2. When a new document is needed, it clones the appropriate prototype
3. The cloned object can then be customized independently
4. This avoids the overhead of creating objects from scratch

## Benefits

- **Performance**: Cloning can be faster than creating new instances
- **Flexibility**: Easy to add new types at runtime
- **Reduced Coupling**: Client doesn't need to know concrete classes
- **Configuration**: Prototypes can be pre-configured with common settings

## Usage

```java
DocumentManager manager = new DocumentManager();
Document doc = manager.createDocument("text");
doc.setTitle("My Document");
Document copy = doc.clone(); // Independent copy
```