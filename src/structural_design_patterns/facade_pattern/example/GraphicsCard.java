package structural_design_patterns.facade_pattern.example;

public class GraphicsCard {
    public void initialize() {
        System.out.println("GraphicsCard: Initializing graphics subsystem");
    }
    
    public void loadDrivers() {
        System.out.println("GraphicsCard: Loading graphics drivers");
    }
    
    public void displayBootScreen() {
        System.out.println("GraphicsCard: Displaying boot screen");
    }
    
    public void setResolution(int width, int height) {
        System.out.println("GraphicsCard: Setting resolution to " + width + "x" + height);
    }
}