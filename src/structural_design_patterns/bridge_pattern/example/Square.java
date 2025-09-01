package structural_design_patterns.bridge_pattern.example;

public class Square extends Shape {
    private double x, y, side;

    public Square(Renderer renderer, double x, double y, double side) {
        super(renderer);
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public void draw() {
        renderer.renderLine(x, y, x + side, y);
        renderer.renderLine(x + side, y, x + side, y + side);
        renderer.renderLine(x + side, y + side, x, y + side);
        renderer.renderLine(x, y + side, x, y);
    }

    @Override
    public void resize(double factor) {
        side *= factor;
        System.out.println("Square resized by factor " + factor + ", new side length: " + side);
    }
}