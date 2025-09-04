package structural_design_patterns.flyweight_pattern.example;

import java.awt.*;

public class TreeType implements Flyweight {
    private String name;
    private Color color;
    private String sprite;
    
    public TreeType(String name, Color color, String sprite) {
        this.name = name;
        this.color = color;
        this.sprite = sprite;
    }
    
    @Override
    public void operation(String extrinsicState) {
        String[] coordinates = extrinsicState.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        render(x, y);
    }
    
    public void render(int x, int y) {
        System.out.println("Rendering " + name + " tree at (" + x + ", " + y + ") with color " + colorToString(color));
    }
    
    private String colorToString(Color color) {
        if (color.equals(Color.GREEN)) return "GREEN";
        if (color.equals(Color.ORANGE)) return "ORANGE";
        if (color.equals(Color.YELLOW)) return "YELLOW";
        return "UNKNOWN";
    }
    
    public String getName() {
        return name;
    }
    
    public Color getColor() {
        return color;
    }
}