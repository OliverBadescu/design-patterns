package behavioral_design_patterns.command_pattern.example;

public class Light {
    private String location;
    private boolean isOn;
    private int brightness;
    
    public Light(String location) {
        this.location = location;
        this.isOn = false;
        this.brightness = 0;
    }
    
    public void turnOn() {
        isOn = true;
        brightness = 100;
        System.out.println(location + " light is ON at " + brightness + "% brightness");
    }
    
    public void turnOff() {
        isOn = false;
        brightness = 0;
        System.out.println(location + " light is OFF");
    }
    
    public void setBrightness(int brightness) {
        if (isOn) {
            this.brightness = brightness;
            System.out.println(location + " light brightness set to " + brightness + "%");
        } else {
            System.out.println("Cannot set brightness. " + location + " light is OFF");
        }
    }
    
    public boolean isOn() {
        return isOn;
    }
    
    public int getBrightness() {
        return brightness;
    }
    
    public String getLocation() {
        return location;
    }
}