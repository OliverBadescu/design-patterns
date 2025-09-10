package behavioral_design_patterns.visitor_pattern.example;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollection {
    private List<Shape> shapes;
    
    public ShapeCollection() {
        this.shapes = new ArrayList<>();
    }
    
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }
    
    public void acceptVisitor(ShapeVisitor visitor) {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
    
    public int getShapeCount() {
        return shapes.size();
    }
    
    public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }
}