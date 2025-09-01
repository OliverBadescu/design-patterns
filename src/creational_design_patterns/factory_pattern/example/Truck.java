package creational_design_patterns.factory_pattern.example;

public class Truck extends Vehicle {
    @Override
    public String startEngine() {
        return "Truck engine started";
    }
    
    @Override
    public String stopEngine() {
        return "Truck engine stopped";
    }
    
    @Override
    public String getInfo() {
        return "This is a truck";
    }
}