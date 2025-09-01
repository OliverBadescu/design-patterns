# Adapter Design Pattern

## Overview

The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate. It acts as a bridge between two incompatible interfaces by wrapping an existing class with a new interface. This pattern is useful when you want to use an existing class, but its interface doesn't match what you need.

## Key Benefits

- **Interface Compatibility**: Enables classes with incompatible interfaces to work together
- **Code Reusability**: Allows existing classes to be used without modification
- **Separation of Concerns**: Keeps interface conversion logic separate from business logic
- **Legacy Integration**: Facilitates integration with legacy code or third-party libraries

## How to Run the Example

1. Navigate to the src directory (parent of structural_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac structural_design_patterns/adapter_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java structural_design_patterns.adapter_pattern.example.AdapterPatternExample
   ```

## Example Structure

The example demonstrates a Media Player that originally only supports MP3 files but is adapted to also play VLC and MP4 files:

### Files Structure:
```
structural_design_patterns/adapter_pattern/
├── example/
│   ├── MediaPlayer.java - Target interface that client expects
│   ├── AdvancedMediaPlayer.java - Adaptee interface with different methods
│   ├── VlcPlayer.java - Concrete implementation for VLC files
│   ├── Mp4Player.java - Concrete implementation for MP4 files
│   ├── MediaAdapter.java - Adapter class that bridges the interfaces
│   ├── AudioPlayer.java - Client class that uses the adapter
│   └── AdapterPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Target Interface**: `MediaPlayer` (what the client expects)
- **Adaptee Interface**: `AdvancedMediaPlayer` (existing interface that needs adaptation)
- **Concrete Adaptees**: `VlcPlayer`, `Mp4Player`
- **Adapter**: `MediaAdapter` (converts between interfaces)
- **Client**: `AudioPlayer` (uses the adapter to play different formats)

## Usage

```java
// Create an audio player that originally only supports MP3
AudioPlayer audioPlayer = new AudioPlayer();

// Now it can play different formats through the adapter
audioPlayer.play("mp3", "song.mp3");     // Direct support
audioPlayer.play("vlc", "movie.vlc");    // Through adapter
audioPlayer.play("mp4", "video.mp4");    // Through adapter
```

## When to Use

- When you want to use an existing class with an incompatible interface
- When you need to create a reusable class that cooperates with unrelated classes
- When you want to integrate third-party libraries with different interfaces
- When working with legacy code that cannot be modified
- When you need to adapt multiple data sources to a unified interface

## Real-World Examples

- Database drivers adapting different database APIs to a common interface
- Media players supporting various file formats
- Payment gateways adapting different payment provider APIs
- File format converters adapting different file types to a common interface