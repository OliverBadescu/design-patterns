package behavioral_design_patterns.observer_pattern.example;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherStation implements Subject {
    private List<Observer> observers;
    private WeatherData currentWeather;
    private String stationName;
    private DateTimeFormatter timeFormatter;
    
    public WeatherStation(String stationName) {
        this.observers = new ArrayList<>();
        this.stationName = stationName;
        this.timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("📡 New observer registered to " + stationName + 
                         " (Total observers: " + observers.size() + ")");
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("📡 Observer removed from " + stationName + 
                         " (Total observers: " + observers.size() + ")");
    }
    
    @Override
    public void notifyObservers() {
        String timestamp = LocalDateTime.now().format(timeFormatter);
        System.out.println("\n🌡️ [" + timestamp + "] " + stationName + 
                         " broadcasting weather update to " + observers.size() + " observers:");
        
        for (Observer observer : observers) {
            observer.update(currentWeather);
        }
    }
    
    public void setWeatherData(float temperature, float humidity, float pressure, String conditions) {
        this.currentWeather = new WeatherData(temperature, humidity, pressure, conditions);
        System.out.println("📊 " + stationName + " - New weather data recorded: " + currentWeather);
        notifyObservers();
    }
    
    public WeatherData getCurrentWeather() {
        return currentWeather;
    }
    
    public String getStationName() {
        return stationName;
    }
    
    public int getObserverCount() {
        return observers.size();
    }
}