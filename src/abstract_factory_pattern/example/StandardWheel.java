package abstract_factory_pattern.example;

public class StandardWheel extends Wheel {
    @Override
    public String getSize() {
        return "16 inch";
    }

    @Override
    public String getType() {
        return "Standard Wheel";
    }

    @Override
    public String getMaterial() {
        return "Steel rim with rubber tire";
    }
}