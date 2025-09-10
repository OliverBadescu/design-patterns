package behavioral_design_patterns.visitor_pattern.example;

public class VisitorPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Visitor Pattern Example ===");
        System.out.println("Demonstrating different operations on shapes without modifying shape classes");
        System.out.println();
        
        ShapeCollection shapes = new ShapeCollection();
        shapes.addShape(new Circle("Small Circle", 5.0));
        shapes.addShape(new Rectangle("Main Rectangle", 10.0, 6.0));
        shapes.addShape(new Triangle("Right Triangle", 8.0, 6.0));
        shapes.addShape(new Circle("Large Circle", 12.0));
        shapes.addShape(new Rectangle("Square", 7.0, 7.0));
        
        System.out.println("Created collection with " + shapes.getShapeCount() + " shapes");
        System.out.println();
        
        System.out.println("1. Drawing all shapes:");
        System.out.println("======================");
        DrawingVisitor drawingVisitor = new DrawingVisitor();
        shapes.acceptVisitor(drawingVisitor);
        
        System.out.println();
        System.out.println("2. Calculating areas:");
        System.out.println("=====================");
        AreaCalculatorVisitor areaVisitor = new AreaCalculatorVisitor();
        shapes.acceptVisitor(areaVisitor);
        System.out.printf("Total area of all shapes: %.2f\n", areaVisitor.getTotalArea());
        
        System.out.println();
        System.out.println("3. Calculating perimeters:");
        System.out.println("==========================");
        PerimeterCalculatorVisitor perimeterVisitor = new PerimeterCalculatorVisitor();
        shapes.acceptVisitor(perimeterVisitor);
        System.out.printf("Total perimeter of all shapes: %.2f\n", perimeterVisitor.getTotalPerimeter());
        
        System.out.println();
        System.out.println("=== Visitor Pattern Benefits Demonstrated ===");
        System.out.println("- Added new operations (draw, area, perimeter) without modifying shape classes");
        System.out.println("- Each visitor encapsulates a specific operation across all shape types");
        System.out.println("- Easy to add new operations by creating new visitor implementations");
        System.out.println("- Separates algorithms from the object structure they operate on");
        
        System.out.println();
        System.out.println("=== Adding a new visitor at runtime ===");
        ShapeVisitor infoVisitor = new ShapeVisitor() {
            @Override
            public void visit(Circle circle) {
                System.out.println("Circle info: " + circle.getName() + " - geometric shape with infinite sides");
            }
            
            @Override
            public void visit(Rectangle rectangle) {
                boolean isSquare = Math.abs(rectangle.getWidth() - rectangle.getHeight()) < 0.001;
                System.out.println("Rectangle info: " + rectangle.getName() + 
                    (isSquare ? " - special case: square" : " - four-sided polygon"));
            }
            
            @Override
            public void visit(Triangle triangle) {
                System.out.println("Triangle info: " + triangle.getName() + " - three-sided polygon");
            }
        };
        
        System.out.println("Shape information:");
        shapes.acceptVisitor(infoVisitor);
    }
}