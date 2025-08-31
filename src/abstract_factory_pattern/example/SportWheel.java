package abstract_factory_pattern.example;

public class SportWheel extends Wheel {
    @Override
    public String getSize() {
        return "18 inch";
    }

    @Override
    public String getType() {
        return "Sport Wheel";
    }

    @Override
    public String getMaterial() {
        return "Alloy rim with performance tire";
    }
}