package behavioral_design_patterns.command_pattern.example;

public class Stereo {
    private String location;
    private boolean isOn;
    private int volume;
    private String source;
    
    public Stereo(String location) {
        this.location = location;
        this.isOn = false;
        this.volume = 0;
        this.source = "CD";
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(location + " stereo is ON");
    }
    
    public void turnOff() {
        isOn = false;
        volume = 0;
        System.out.println(location + " stereo is OFF");
    }
    
    public void setVolume(int volume) {
        if (isOn) {
            this.volume = volume;
            System.out.println(location + " stereo volume set to " + volume);
        } else {
            System.out.println("Cannot set volume. " + location + " stereo is OFF");
        }
    }
    
    public void setSource(String source) {
        if (isOn) {
            this.source = source;
            System.out.println(location + " stereo source set to " + source);
        } else {
            System.out.println("Cannot set source. " + location + " stereo is OFF");
        }
    }
    
    public boolean isOn() {
        return isOn;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public String getSource() {
        return source;
    }
}