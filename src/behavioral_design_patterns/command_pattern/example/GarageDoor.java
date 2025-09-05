package behavioral_design_patterns.command_pattern.example;

public class GarageDoor {
    private String location;
    private boolean isOpen;
    
    public GarageDoor(String location) {
        this.location = location;
        this.isOpen = false;
    }
    
    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println(location + " garage door is OPEN");
        } else {
            System.out.println(location + " garage door is already OPEN");
        }
    }
    
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println(location + " garage door is CLOSED");
        } else {
            System.out.println(location + " garage door is already CLOSED");
        }
    }
    
    public boolean isOpen() {
        return isOpen;
    }
}