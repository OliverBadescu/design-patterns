package creational_design_patterns.abstract_factory_pattern.example;

public class EconomyVehicleFactory extends VehicleComponentFactory {
    @Override
    public Engine createEngine() {
        return new PetrolEngine();
    }

    @Override
    public Wheel createWheel() {
        return new StandardWheel();
    }
}