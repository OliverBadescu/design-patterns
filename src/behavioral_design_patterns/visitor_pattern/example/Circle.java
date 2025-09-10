package behavioral_design_patterns.visitor_pattern.example;

public class Circle extends Shape {
    private double radius;
    
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}