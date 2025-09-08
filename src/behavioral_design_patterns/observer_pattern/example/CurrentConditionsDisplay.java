package behavioral_design_patterns.observer_pattern.example;

public class CurrentConditionsDisplay implements Observer {
    private String displayName;
    private WeatherData lastWeatherData;
    
    public CurrentConditionsDisplay(String displayName) {
        this.displayName = displayName;
    }
    
    @Override
    public void update(WeatherData weatherData) {
        this.lastWeatherData = weatherData;
        display();
    }
    
    private void display() {
        System.out.println("🖥️ " + displayName + " - Current Conditions:");
        System.out.println("   Temperature: " + lastWeatherData.getTemperature() + "°C");
        System.out.println("   Humidity: " + lastWeatherData.getHumidity() + "%");
        System.out.println("   Conditions: " + lastWeatherData.getConditions());
    }
    
    public String getDisplayName() {
        return displayName;
    }
}