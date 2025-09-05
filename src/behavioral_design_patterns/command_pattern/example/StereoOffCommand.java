package behavioral_design_patterns.command_pattern.example;

public class StereoOffCommand implements Command {
    private Stereo stereo;
    private int previousVolume;
    private String previousSource;
    private boolean wasOn;
    
    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    
    @Override
    public void execute() {
        wasOn = stereo.isOn();
        if (wasOn) {
            previousVolume = stereo.getVolume();
            previousSource = stereo.getSource();
        }
        stereo.turnOff();
    }
    
    @Override
    public void undo() {
        if (wasOn) {
            stereo.turnOn();
            stereo.setSource(previousSource);
            stereo.setVolume(previousVolume);
        }
    }
}