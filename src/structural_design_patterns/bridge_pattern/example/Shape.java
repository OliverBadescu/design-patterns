package structural_design_patterns.bridge_pattern.example;

public abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    
    public abstract void resize(double factor);
}