package structural_design_patterns.bridge_pattern.example;

public class Triangle extends Shape {
    private double x1, y1, x2, y2, x3, y3;

    public Triangle(Renderer renderer, double x1, double y1, double x2, double y2, double x3, double y3) {
        super(renderer);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw() {
        renderer.renderLine(x1, y1, x2, y2);
        renderer.renderLine(x2, y2, x3, y3);
        renderer.renderLine(x3, y3, x1, y1);
    }

    @Override
    public void resize(double factor) {
        x1 *= factor; y1 *= factor;
        x2 *= factor; y2 *= factor;
        x3 *= factor; y3 *= factor;
        System.out.println("Triangle resized by factor " + factor);
    }
}