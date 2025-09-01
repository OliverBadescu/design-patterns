package creational_design_patterns.factory_pattern.example;

public class Car extends Vehicle {
    @Override
    public String startEngine() {
        return "Car engine started";
    }
    
    @Override
    public String stopEngine() {
        return "Car engine stopped";
    }
    
    @Override
    public String getInfo() {
        return "This is a car";
    }
}