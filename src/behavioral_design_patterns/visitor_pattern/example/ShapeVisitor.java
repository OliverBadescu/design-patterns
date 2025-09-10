package behavioral_design_patterns.visitor_pattern.example;

public interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Triangle triangle);
}