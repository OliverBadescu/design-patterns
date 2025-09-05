# Command Pattern

## Overview
The Command pattern turns a request into a stand-alone object that contains all information about the request. This transformation allows you to parameterize methods with different requests, delay or queue a request's execution, and support undo operations. It decouples the object that invokes the operation from the object that performs it.

## Key Benefits
- **Decoupling**: Separates the object that invokes the operation from the one that performs it
- **Flexibility**: New commands can be added without changing existing client code
- **Undo/Redo Support**: Commands can store state to reverse their effect
- **Macro Commands**: You can combine simple commands into complex composite commands
- **Logging and Queuing**: Commands can be stored, logged, and executed later
- **Remote Execution**: Commands can be serialized and executed on different machines

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/command_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.command_pattern.example.CommandPatternExample
   ```

## Example Structure

The example demonstrates a smart home automation system where different devices can be controlled through a remote control with undo functionality and macro commands:

### Files Structure:
```
behavioral_design_patterns/command_pattern/
├── example/
│   ├── Command.java - Command interface with execute() and undo() methods
│   ├── Light.java - Receiver: Smart light with on/off and brightness control
│   ├── Stereo.java - Receiver: Stereo system with volume and source control
│   ├── GarageDoor.java - Receiver: Garage door with open/close functionality
│   ├── LightOnCommand.java - Concrete command for turning light on
│   ├── LightOffCommand.java - Concrete command for turning light off
│   ├── StereoOnWithCDCommand.java - Concrete command for stereo with CD
│   ├── StereoOffCommand.java - Concrete command for turning stereo off
│   ├── GarageDoorOpenCommand.java - Concrete command for opening garage
│   ├── GarageDoorCloseCommand.java - Concrete command for closing garage
│   ├── NoCommand.java - Null object pattern for unassigned slots
│   ├── MacroCommand.java - Composite command for executing multiple commands
│   ├── RemoteControl.java - Invoker: Remote with multiple slots and undo
│   └── CommandPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Command**: `Command` interface (defines execute() and undo())
- **Concrete Commands**: Various device-specific commands
- **Receivers**: `Light`, `Stereo`, `GarageDoor` (perform actual work)
- **Invoker**: `RemoteControl` (triggers commands)
- **Client**: `CommandPatternExample` (creates and configures commands)

## Usage

```java
// Create devices (receivers)
Light livingRoomLight = new Light("Living Room");
Stereo stereo = new Stereo("Living Room");

// Create commands
LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);

// Set up remote control (invoker)
RemoteControl remote = new RemoteControl();
remote.setCommand(0, lightOn, lightOff);

// Execute commands
remote.onButtonPressed(0);  // Turn light on
remote.undoButtonPressed(); // Undo (turn light off)
```

## When to Use

- When you want to parameterize objects with operations
- When you want to queue operations, schedule their execution, or execute them remotely
- When you want to implement reversible operations (undo/redo functionality)
- When you want to implement logging where operations can be replayed in case of system crash
- When you want to structure a system around high-level operations built on primitive operations
- When you need to decouple the class that invokes the operation from the class that performs it

## Real-World Examples

- GUI buttons and menu items in applications
- Macro recording in text editors and IDEs
- Database transaction management and rollback
- Network request queuing and retry mechanisms
- Job scheduling systems
- Smart home automation systems
- Undo/Redo functionality in applications