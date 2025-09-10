package behavioral_design_patterns.visitor_pattern.example;

public class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }
    
    public double getBase() {
        return base;
    }
    
    public double getHeight() {
        return height;
    }
    
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}