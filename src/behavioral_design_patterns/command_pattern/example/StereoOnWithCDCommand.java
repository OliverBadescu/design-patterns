package behavioral_design_patterns.command_pattern.example;

public class StereoOnWithCDCommand implements Command {
    private Stereo stereo;
    private int previousVolume;
    private String previousSource;
    private boolean wasOn;
    
    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    
    @Override
    public void execute() {
        wasOn = stereo.isOn();
        if (wasOn) {
            previousVolume = stereo.getVolume();
            previousSource = stereo.getSource();
        }
        
        stereo.turnOn();
        stereo.setSource("CD");
        stereo.setVolume(11);
    }
    
    @Override
    public void undo() {
        if (wasOn) {
            stereo.setSource(previousSource);
            stereo.setVolume(previousVolume);
        } else {
            stereo.turnOff();
        }
    }
}