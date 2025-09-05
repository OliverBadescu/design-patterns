package behavioral_design_patterns.command_pattern.example;

public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;
    
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
    
    @Override
    public void execute() {
        garageDoor.open();
    }
    
    @Override
    public void undo() {
        garageDoor.close();
    }
}