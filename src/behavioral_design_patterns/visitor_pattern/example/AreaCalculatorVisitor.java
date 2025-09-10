package behavioral_design_patterns.visitor_pattern.example;

public class AreaCalculatorVisitor implements ShapeVisitor {
    private double totalArea = 0;
    
    @Override
    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        System.out.printf("Circle '%s' area: %.2f\n", circle.getName(), area);
        totalArea += area;
    }
    
    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        System.out.printf("Rectangle '%s' area: %.2f\n", rectangle.getName(), area);
        totalArea += area;
    }
    
    @Override
    public void visit(Triangle triangle) {
        double area = 0.5 * triangle.getBase() * triangle.getHeight();
        System.out.printf("Triangle '%s' area: %.2f\n", triangle.getName(), area);
        totalArea += area;
    }
    
    public double getTotalArea() {
        return totalArea;
    }
    
    public void reset() {
        totalArea = 0;
    }
}