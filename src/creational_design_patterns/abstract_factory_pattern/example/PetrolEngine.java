package creational_design_patterns.abstract_factory_pattern.example;

public class PetrolEngine extends Engine {
    @Override
    public String start() {
        return "Petrol engine started with ignition";
    }

    @Override
    public String stop() {
        return "Petrol engine stopped";
    }

    @Override
    public String getType() {
        return "Petrol Engine";
    }
}