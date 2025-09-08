# Memento Pattern

## Overview
The Memento pattern provides the ability to restore an object to its previous state without violating encapsulation. It captures and externalizes an object's internal state so that the object can be restored to this state later, all without exposing the internal structure of the object. This pattern is commonly used to implement undo/redo functionality.

## Key Benefits
- **State Preservation**: Captures complete object state without exposing internals
- **Encapsulation**: Maintains object's data encapsulation while enabling state restoration
- **Undo/Redo Support**: Enables implementation of undo and redo operations
- **History Management**: Supports multiple saved states with flexible management
- **Rollback Capability**: Easy rollback to any previous state
- **Debugging Aid**: State snapshots can help with debugging and testing

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/memento_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.memento_pattern.example.MementoPatternExample
   ```

## Example Structure

The example demonstrates a text editor with comprehensive undo/redo functionality that preserves both content and cursor position:

### Files Structure:
```
behavioral_design_patterns/memento_pattern/
├── example/
│   ├── TextEditorMemento.java - Memento storing editor state with metadata
│   ├── TextEditor.java - Originator that creates and restores from mementos
│   ├── EditorHistory.java - Caretaker managing memento history with undo/redo
│   └── MementoPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Memento**: `TextEditorMemento` (stores state snapshot with timestamp and description)
- **Originator**: `TextEditor` (creates mementos and restores from them)
- **Caretaker**: `EditorHistory` (manages memento collection and provides undo/redo)
- **Client**: `MementoPatternExample` (coordinates operations between components)

## Usage

```java
// Create editor and history manager
TextEditor editor = new TextEditor();
EditorHistory history = new EditorHistory();

// Perform operations and save states
editor.type("Hello World!");
history.save(editor.createMemento("Initial text"));

editor.type(" - Updated");
history.save(editor.createMemento("Added update"));

// Undo operation
TextEditorMemento memento = history.undo();
if (memento != null) {
    editor.restoreFromMemento(memento);
}

// Redo operation
memento = history.redo();
if (memento != null) {
    editor.restoreFromMemento(memento);
}

// View history
history.showHistory();
```

## When to Use

- When you need to provide undo/redo functionality
- When you want to save snapshots of an object's state for later restoration
- When direct access to object fields would violate encapsulation
- When you need to implement checkpoint and rollback mechanisms
- When you want to support multiple levels of undo operations
- When you need to preserve object state for debugging or testing purposes

## Real-World Examples

- Text editors and IDEs (undo/redo functionality)
- Image editing software (history states)
- Database transaction rollback mechanisms
- Game save states and checkpoints
- Web browser navigation history
- Configuration management systems
- Drawing and CAD applications
- Financial trading systems (state rollback)
- Version control systems
- Wizard-like user interfaces with back/forward navigation

## Implementation Variations

### Simple Memento
- Stores minimal state required for restoration
- Lightweight for frequent state saving

### Rich Memento
- Includes metadata like timestamps, descriptions
- Better for debugging and user interface display

### Compressed Memento
- Uses compression for large state objects
- Optimizes memory usage for extensive history

### Incremental Memento
- Stores only changes rather than full state
- Efficient for objects with large state and small changes