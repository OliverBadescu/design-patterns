package behavioral_design_patterns.visitor_pattern.example;

public class DrawingVisitor implements ShapeVisitor {
    
    @Override
    public void visit(Circle circle) {
        System.out.printf("Drawing Circle '%s' with radius %.2f\n", 
            circle.getName(), circle.getRadius());
        System.out.println("  ○  <- Circle drawn with curves and arcs");
    }
    
    @Override
    public void visit(Rectangle rectangle) {
        System.out.printf("Drawing Rectangle '%s' with width %.2f and height %.2f\n", 
            rectangle.getName(), rectangle.getWidth(), rectangle.getHeight());
        System.out.println("  ▭  <- Rectangle drawn with straight lines");
    }
    
    @Override
    public void visit(Triangle triangle) {
        System.out.printf("Drawing Triangle '%s' with base %.2f and height %.2f\n", 
            triangle.getName(), triangle.getBase(), triangle.getHeight());
        System.out.println("  △  <- Triangle drawn with three connected lines");
    }
}