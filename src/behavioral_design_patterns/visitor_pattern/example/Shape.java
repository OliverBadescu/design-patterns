package behavioral_design_patterns.visitor_pattern.example;

public abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void accept(ShapeVisitor visitor);
}