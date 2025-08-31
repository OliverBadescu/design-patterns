package abstract_factory_pattern.example;

public abstract class VehicleComponentFactory {
    public abstract Engine createEngine();
    public abstract Wheel createWheel();
}