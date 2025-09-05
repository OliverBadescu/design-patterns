package behavioral_design_patterns.command_pattern.example;

public class GarageDoorCloseCommand implements Command {
    private GarageDoor garageDoor;
    
    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
    
    @Override
    public void execute() {
        garageDoor.close();
    }
    
    @Override
    public void undo() {
        garageDoor.open();
    }
}