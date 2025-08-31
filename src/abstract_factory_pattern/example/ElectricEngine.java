package abstract_factory_pattern.example;

public class ElectricEngine extends Engine {
    @Override
    public String start() {
        return "Electric motor started silently";
    }

    @Override
    public String stop() {
        return "Electric motor stopped";
    }

    @Override
    public String getType() {
        return "Electric Motor";
    }
}