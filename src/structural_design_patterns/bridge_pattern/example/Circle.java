package structural_design_patterns.bridge_pattern.example;

public class Circle extends Shape {
    private double x, y, radius;

    public Circle(Renderer renderer, double x, double y, double radius) {
        super(renderer);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(x, y, radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Circle resized by factor " + factor + ", new radius: " + radius);
    }
}