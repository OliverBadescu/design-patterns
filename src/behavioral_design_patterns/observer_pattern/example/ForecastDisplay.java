package behavioral_design_patterns.observer_pattern.example;

public class ForecastDisplay implements Observer {
    private String displayName;
    private float lastPressure = 29.92f;
    private float currentPressure = 29.92f;
    
    public ForecastDisplay(String displayName) {
        this.displayName = displayName;
    }
    
    @Override
    public void update(WeatherData weatherData) {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }
    
    private void display() {
        String forecast;
        if (currentPressure > lastPressure) {
            forecast = "Improving weather on the way!";
        } else if (currentPressure == lastPressure) {
            forecast = "More of the same weather ahead";
        } else {
            forecast = "Watch out for cooler, rainy weather";
        }
        
        System.out.println("📈 " + displayName + " - Weather Forecast:");
        System.out.println("   Pressure trend: " + String.format("%.2f", lastPressure) + 
                         " → " + String.format("%.2f", currentPressure) + " hPa");
        System.out.println("   Forecast: " + forecast);
    }
    
    public String getDisplayName() {
        return displayName;
    }
}