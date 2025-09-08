# Observer Pattern

## Overview
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. This pattern is also known as the Publish-Subscribe pattern. It promotes loose coupling between the subject (publisher) and its observers (subscribers) by ensuring that observers only need to know about the subject interface, not its implementation details.

## Key Benefits
- **Loose Coupling**: Subject and observers are loosely coupled through interfaces
- **Dynamic Relationships**: Observers can be added or removed at runtime
- **Broadcast Communication**: Single notification can update multiple observers
- **Open/Closed Principle**: New observer types can be added without modifying existing code
- **Separation of Concerns**: Subject focuses on data management, observers on presentation/processing
- **Push Model**: Observers receive updates automatically without polling

## How to Run the Example

1. Navigate to the src directory (parent of behavioral_design_patterns):
   ```bash
   cd src
   ```

2. Compile all Java files:
   ```bash
   javac behavioral_design_patterns/observer_pattern/example/*.java
   ```

3. Run the example:
   ```bash
   java behavioral_design_patterns.observer_pattern.example.ObserverPatternExample
   ```

## Example Structure

The example demonstrates a weather monitoring system where multiple displays automatically update when weather conditions change:

### Files Structure:
```
behavioral_design_patterns/observer_pattern/
├── example/
│   ├── Observer.java - Observer interface with update method
│   ├── Subject.java - Subject interface for managing observers
│   ├── WeatherData.java - Data class containing weather measurements
│   ├── WeatherStation.java - Concrete subject that broadcasts weather updates
│   ├── CurrentConditionsDisplay.java - Observer showing current weather
│   ├── ForecastDisplay.java - Observer providing weather forecast based on pressure trends
│   ├── StatisticsDisplay.java - Observer calculating weather statistics over time
│   ├── HeatIndexDisplay.java - Observer computing and displaying heat index
│   └── ObserverPatternExample.java - Main class demonstrating the pattern
└── README.md
```

### Pattern Components:
- **Subject**: `Subject` interface (manages observer collection and notifications)
- **Concrete Subject**: `WeatherStation` (maintains weather data and notifies observers)
- **Observer**: `Observer` interface (defines update method)
- **Concrete Observers**: Various display classes (receive and process weather updates)
- **Data Object**: `WeatherData` (encapsulates weather information)
- **Client**: `ObserverPatternExample` (sets up the system and demonstrates functionality)

## Usage

```java
// Create subject (weather station)
WeatherStation station = new WeatherStation("Main Station");

// Create observers (displays)
CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay("Main Display");
ForecastDisplay forecast = new ForecastDisplay("Forecast Display");
StatisticsDisplay stats = new StatisticsDisplay("Statistics Display");

// Register observers with subject
station.registerObserver(currentDisplay);
station.registerObserver(forecast);
station.registerObserver(stats);

// Update weather data - all observers are automatically notified
station.setWeatherData(25.0f, 65.0f, 1013.2f, "Sunny");

// Remove an observer
station.removeObserver(forecast);

// Add new observer at runtime
HeatIndexDisplay heatIndex = new HeatIndexDisplay("Heat Index Display");
station.registerObserver(heatIndex);
```

## When to Use

- When changes to one object require updating multiple dependent objects
- When you want to notify objects without making assumptions about who they are
- When the coupling between subject and observers should be minimal
- When you need to support broadcast-style communication
- When you want to add or remove observers dynamically
- When implementing event handling systems or model-view architectures

## Real-World Examples

- GUI event handling systems (button clicks, window events)
- Model-View-Controller (MVC) architecture
- News feed subscriptions and social media notifications
- Stock price monitoring and trading applications
- Email subscription services
- RSS feed readers
- Database triggers and change notifications
- IoT sensor data broadcasting
- Chat applications and messaging systems
- Game state updates and multiplayer synchronization

## Comparison with Other Patterns

### Observer vs Mediator
- **Observer**: One-to-many dependency, subject notifies all observers
- **Mediator**: Many-to-many communication through central mediator
- **Observer**: Direct relationship between subject and observers
- **Mediator**: Objects don't reference each other directly

### Observer vs Chain of Responsibility
- **Observer**: All observers receive the notification
- **Chain of Responsibility**: Only one handler in the chain processes the request
- **Observer**: Multiple handlers can process the same event
- **Chain of Responsibility**: Request stops at the first suitable handler