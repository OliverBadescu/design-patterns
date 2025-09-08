package behavioral_design_patterns.observer_pattern.example;

public class ObserverPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Weather Station Observer Pattern Demo ===");
        
        // Create weather station (subject)
        WeatherStation centralStation = new WeatherStation("Central Weather Station");
        
        // Create different display observers
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay("Main Display");
        ForecastDisplay forecastDisplay = new ForecastDisplay("Forecast Display");
        StatisticsDisplay statsDisplay = new StatisticsDisplay("Statistics Display", 5);
        HeatIndexDisplay heatDisplay = new HeatIndexDisplay("Heat Index Display");
        
        System.out.println("\n--- Registering Weather Displays ---");
        centralStation.registerObserver(currentDisplay);
        centralStation.registerObserver(forecastDisplay);
        centralStation.registerObserver(statsDisplay);
        centralStation.registerObserver(heatDisplay);
        
        System.out.println("\n--- First Weather Update ---");
        centralStation.setWeatherData(25.5f, 65.0f, 1013.2f, "Partly Cloudy");
        
        System.out.println("\n--- Second Weather Update ---");
        centralStation.setWeatherData(27.2f, 70.0f, 1011.8f, "Cloudy");
        
        System.out.println("\n--- Third Weather Update ---");
        centralStation.setWeatherData(23.1f, 60.0f, 1015.5f, "Clear");
        
        System.out.println("\n--- Removing Forecast Display ---");
        centralStation.removeObserver(forecastDisplay);
        
        System.out.println("\n--- Fourth Weather Update (without Forecast Display) ---");
        centralStation.setWeatherData(29.8f, 75.0f, 1009.3f, "Hot and Humid");
        
        System.out.println("\n--- Adding New Display ---");
        CurrentConditionsDisplay mobileDisplay = new CurrentConditionsDisplay("Mobile App Display");
        centralStation.registerObserver(mobileDisplay);
        
        System.out.println("\n--- Fifth Weather Update (with Mobile Display) ---");
        centralStation.setWeatherData(31.5f, 80.0f, 1007.1f, "Very Hot");
        
        System.out.println("\n--- Sixth Weather Update (Cooler Weather) ---");
        centralStation.setWeatherData(18.2f, 45.0f, 1018.7f, "Cool and Clear");
        
        System.out.println("\n--- Creating Second Weather Station ---");
        WeatherStation airportStation = new WeatherStation("Airport Weather Station");
        
        // Create observer that can observe multiple stations
        StatisticsDisplay airportStats = new StatisticsDisplay("Airport Statistics", 3);
        airportStation.registerObserver(airportStats);
        airportStation.registerObserver(currentDisplay); // Same display observing two stations
        
        System.out.println("\n--- Airport Weather Update ---");
        airportStation.setWeatherData(22.0f, 55.0f, 1014.0f, "Fair");
        
        System.out.println("\n--- Final Central Station Update ---");
        centralStation.setWeatherData(26.0f, 62.0f, 1012.5f, "Pleasant");
        
        System.out.println("\n--- Demonstrating Observer Benefits ---");
        System.out.println("✅ Loose coupling: Displays don't know about each other");
        System.out.println("✅ Dynamic relationships: Observers can be added/removed at runtime");
        System.out.println("✅ Broadcast communication: One weather update notifies all displays");
        System.out.println("✅ Open/Closed Principle: New display types can be added without changing existing code");
        System.out.println("✅ Multiple subjects: Same observer can observe different weather stations");
        System.out.println("✅ Automatic updates: No polling needed, observers are pushed updates");
        
        System.out.println("\n--- Final State ---");
        System.out.println("Central Station observers: " + centralStation.getObserverCount());
        System.out.println("Airport Station observers: " + airportStation.getObserverCount());
        System.out.println("Statistics readings collected: " + statsDisplay.getReadingCount());
        
        System.out.println("\n=== Demo Complete ===");
    }
}