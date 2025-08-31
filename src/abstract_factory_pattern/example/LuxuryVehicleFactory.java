package abstract_factory_pattern.example;

public class LuxuryVehicleFactory extends VehicleComponentFactory {
    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }

    @Override
    public Wheel createWheel() {
        return new SportWheel();
    }
}