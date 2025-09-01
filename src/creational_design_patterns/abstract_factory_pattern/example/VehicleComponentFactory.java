package creational_design_patterns.abstract_factory_pattern.example;

public abstract class VehicleComponentFactory {
    public abstract Engine createEngine();
    public abstract Wheel createWheel();
}