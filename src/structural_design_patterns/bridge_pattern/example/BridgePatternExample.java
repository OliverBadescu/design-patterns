package structural_design_patterns.bridge_pattern.example;

public class BridgePatternExample {
    public static void main(String[] args) {
        System.out.println("Bridge Pattern Example - Drawing Application");
        System.out.println("============================================");
        
        VectorRenderer vectorRenderer = new VectorRenderer();
        RasterRenderer rasterRenderer = new RasterRenderer();
        
        System.out.println("\n--- Drawing shapes with Vector Renderer ---");
        Shape circle = new Circle(vectorRenderer, 5, 10, 3);
        Shape square = new Square(vectorRenderer, 0, 0, 4);
        Shape triangle = new Triangle(vectorRenderer, 0, 0, 2, 0, 1, 2);
        
        circle.draw();
        square.draw();
        triangle.draw();
        
        System.out.println("\n--- Drawing shapes with Raster Renderer ---");
        Shape rasterCircle = new Circle(rasterRenderer, 10, 5, 2);
        Shape rasterSquare = new Square(rasterRenderer, 2, 2, 3);
        Shape rasterTriangle = new Triangle(rasterRenderer, 1, 1, 3, 1, 2, 3);
        
        rasterCircle.draw();
        rasterSquare.draw();
        rasterTriangle.draw();
        
        System.out.println("\n--- Resizing shapes ---");
        circle.resize(1.5);
        circle.draw();
        
        square.resize(0.8);
        square.draw();
    }
}