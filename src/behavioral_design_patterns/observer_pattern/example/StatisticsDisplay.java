package behavioral_design_patterns.observer_pattern.example;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer {
    private String displayName;
    private List<Float> temperatureHistory;
    private List<Float> humidityHistory;
    private int maxHistorySize;
    
    public StatisticsDisplay(String displayName) {
        this(displayName, 10);
    }
    
    public StatisticsDisplay(String displayName, int maxHistorySize) {
        this.displayName = displayName;
        this.maxHistorySize = maxHistorySize;
        this.temperatureHistory = new ArrayList<>();
        this.humidityHistory = new ArrayList<>();
    }
    
    @Override
    public void update(WeatherData weatherData) {
        addToHistory(temperatureHistory, weatherData.getTemperature());
        addToHistory(humidityHistory, weatherData.getHumidity());
        display();
    }
    
    private void addToHistory(List<Float> history, float value) {
        history.add(value);
        if (history.size() > maxHistorySize) {
            history.remove(0);
        }
    }
    
    private void display() {
        if (temperatureHistory.isEmpty()) {
            return;
        }
        
        float avgTemp = calculateAverage(temperatureHistory);
        float minTemp = calculateMin(temperatureHistory);
        float maxTemp = calculateMax(temperatureHistory);
        
        float avgHumidity = calculateAverage(humidityHistory);
        float minHumidity = calculateMin(humidityHistory);
        float maxHumidity = calculateMax(humidityHistory);
        
        System.out.println("📊 " + displayName + " - Weather Statistics (last " + 
                         temperatureHistory.size() + " readings):");
        System.out.println("   Temperature: Avg " + String.format("%.1f", avgTemp) + "°C, " +
                         "Min " + String.format("%.1f", minTemp) + "°C, " +
                         "Max " + String.format("%.1f", maxTemp) + "°C");
        System.out.println("   Humidity: Avg " + String.format("%.1f", avgHumidity) + "%, " +
                         "Min " + String.format("%.1f", minHumidity) + "%, " +
                         "Max " + String.format("%.1f", maxHumidity) + "%");
    }
    
    private float calculateAverage(List<Float> values) {
        return (float) values.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);
    }
    
    private float calculateMin(List<Float> values) {
        return (float) values.stream().mapToDouble(Float::doubleValue).min().orElse(0.0);
    }
    
    private float calculateMax(List<Float> values) {
        return (float) values.stream().mapToDouble(Float::doubleValue).max().orElse(0.0);
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public int getReadingCount() {
        return temperatureHistory.size();
    }
}