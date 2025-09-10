package behavioral_design_patterns.visitor_pattern.example;

public class PerimeterCalculatorVisitor implements ShapeVisitor {
    private double totalPerimeter = 0;
    
    @Override
    public void visit(Circle circle) {
        double perimeter = 2 * Math.PI * circle.getRadius();
        System.out.printf("Circle '%s' perimeter: %.2f\n", circle.getName(), perimeter);
        totalPerimeter += perimeter;
    }
    
    @Override
    public void visit(Rectangle rectangle) {
        double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
        System.out.printf("Rectangle '%s' perimeter: %.2f\n", rectangle.getName(), perimeter);
        totalPerimeter += perimeter;
    }
    
    @Override
    public void visit(Triangle triangle) {
        double side1 = triangle.getBase();
        double side2 = triangle.getHeight();
        double side3 = Math.sqrt(side1 * side1 + side2 * side2);
        double perimeter = side1 + side2 + side3;
        System.out.printf("Triangle '%s' perimeter: %.2f\n", triangle.getName(), perimeter);
        totalPerimeter += perimeter;
    }
    
    public double getTotalPerimeter() {
        return totalPerimeter;
    }
    
    public void reset() {
        totalPerimeter = 0;
    }
}