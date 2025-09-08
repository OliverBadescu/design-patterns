package behavioral_design_patterns.observer_pattern.example;

public class HeatIndexDisplay implements Observer {
    private String displayName;
    private float heatIndex = 0.0f;
    
    public HeatIndexDisplay(String displayName) {
        this.displayName = displayName;
    }
    
    @Override
    public void update(WeatherData weatherData) {
        heatIndex = calculateHeatIndex(weatherData.getTemperature(), weatherData.getHumidity());
        display();
    }
    
    private float calculateHeatIndex(float temperature, float humidity) {
        // Convert Celsius to Fahrenheit for heat index calculation
        float tempF = (temperature * 9f/5f) + 32f;
        
        // Simplified heat index calculation
        float heatIndexF = (float) (-42.379 + 
                                   2.04901523 * tempF +
                                   10.14333127 * humidity +
                                   -0.22475541 * tempF * humidity +
                                   -0.00683783 * tempF * tempF +
                                   -0.05481717 * humidity * humidity +
                                   0.00122874 * tempF * tempF * humidity +
                                   0.00085282 * tempF * humidity * humidity +
                                   -0.00000199 * tempF * tempF * humidity * humidity);
        
        // Convert back to Celsius
        return (heatIndexF - 32f) * 5f/9f;
    }
    
    private void display() {
        String comfort;
        if (heatIndex < 27) {
            comfort = "Comfortable";
        } else if (heatIndex < 32) {
            comfort = "Caution - Fatigue possible";
        } else if (heatIndex < 40) {
            comfort = "Extreme Caution - Heat exhaustion possible";
        } else if (heatIndex < 52) {
            comfort = "Danger - Heat stroke possible";
        } else {
            comfort = "Extreme Danger - Heat stroke imminent";
        }
        
        System.out.println("🌡️ " + displayName + " - Heat Index:");
        System.out.println("   Heat Index: " + String.format("%.1f", heatIndex) + "°C");
        System.out.println("   Comfort Level: " + comfort);
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public float getHeatIndex() {
        return heatIndex;
    }
}