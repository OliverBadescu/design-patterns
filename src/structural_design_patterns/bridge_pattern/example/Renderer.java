package structural_design_patterns.bridge_pattern.example;

public interface Renderer {
    void renderLine(double x1, double y1, double x2, double y2);
    void renderCircle(double x, double y, double radius);
}