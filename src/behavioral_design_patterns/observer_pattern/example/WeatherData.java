package behavioral_design_patterns.observer_pattern.example;

public class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;
    private String conditions;
    
    public WeatherData(float temperature, float humidity, float pressure, String conditions) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.conditions = conditions;
    }
    
    public float getTemperature() {
        return temperature;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
    
    public String getConditions() {
        return conditions;
    }
    
    @Override
    public String toString() {
        return String.format("Temperature: %.1f°C, Humidity: %.1f%%, Pressure: %.1f hPa, Conditions: %s",
                           temperature, humidity, pressure, conditions);
    }
}