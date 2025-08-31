package factory_pattern.example;

public class Motorcycle extends Vehicle {
    @Override
    public String startEngine() {
        return "Motorcycle engine started";
    }
    
    @Override
    public String stopEngine() {
        return "Motorcycle engine stopped";
    }
    
    @Override
    public String getInfo() {
        return "This is a motorcycle";
    }
}