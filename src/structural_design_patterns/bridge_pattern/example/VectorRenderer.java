package structural_design_patterns.bridge_pattern.example;

public class VectorRenderer implements Renderer {
    @Override
    public void renderLine(double x1, double y1, double x2, double y2) {
        System.out.println("Vector: Drawing line from (" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")");
    }

    @Override
    public void renderCircle(double x, double y, double radius) {
        System.out.println("Vector: Drawing circle at (" + x + "," + y + ") with radius " + radius);
    }
}