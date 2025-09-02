# Composite Pattern

The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

## Key Components

1. **Component**: The base interface for all objects in the composition
2. **Leaf**: Represents leaf objects in the composition (has no children)
3. **Composite**: Defines behavior for components having children and stores child components

## Benefits

- Clients can treat individual objects and compositions uniformly
- Makes it easier to add new kinds of components
- Provides flexibility of structure

## Example

The example demonstrates a file system structure where:
- `FileSystemComponent` is the component interface
- `File` is a leaf node (cannot contain other components)
- `Directory` is a composite node (can contain files and other directories)

## How to Use

1. **Create leaf components (Files):**
   ```java
   File file1 = new File("document.txt", 1024);
   File file2 = new File("image.jpg", 2048);
   ```

2. **Create composite components (Directories):**
   ```java
   Directory rootDir = new Directory("root");
   Directory documentsDir = new Directory("documents");
   ```

3. **Build the structure by adding components:**
   ```java
   rootDir.add(documentsDir);
   rootDir.add(file1);
   documentsDir.add(file2);
   ```

4. **Use components uniformly:**
   ```java
   // Both files and directories have the same interface
   rootDir.display(0);           // Shows entire tree structure
   long size = rootDir.getSize(); // Gets total size recursively
   ```

5. **Run the example:**
   ```bash
   javac structural_design_patterns/composite_pattern/example/*.java
   java structural_design_patterns.composite_pattern.example.CompositePatternExample
   ```

## Key Operations

- **display(int indent)**: Shows the component with proper indentation
- **getSize()**: Returns size (individual file size or total directory size)
- **add(component)**: Adds a child component (directories only)
- **remove(component)**: Removes a child component (directories only)
- **getChild(index)**: Gets a child component by index (directories only)