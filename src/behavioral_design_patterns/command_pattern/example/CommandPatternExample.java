package behavioral_design_patterns.command_pattern.example;

public class CommandPatternExample {
    public static void main(String[] args) {
        // Create the remote control (invoker)
        RemoteControl remoteControl = new RemoteControl();
        
        // Create devices (receivers)
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Stereo stereo = new Stereo("Living Room");
        GarageDoor garageDoor = new GarageDoor("Main");
        
        // Create commands
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);
        
        // Set up the remote control with commands
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
        remoteControl.setCommand(3, garageDoorOpen, garageDoorClose);
        
        System.out.println("=== Smart Home Remote Control Demo ===");
        System.out.println(remoteControl);
        
        // Test individual commands
        System.out.println("--- Testing Individual Commands ---");
        remoteControl.onButtonPressed(0);  // Living room light on
        remoteControl.onButtonPressed(1);  // Kitchen light on
        remoteControl.onButtonPressed(2);  // Stereo on with CD
        remoteControl.onButtonPressed(3);  // Garage door open
        
        System.out.println("\n--- Testing Undo ---");
        remoteControl.undoButtonPressed(); // Undo garage door open
        remoteControl.undoButtonPressed(); // Undo stereo on
        
        System.out.println("\n--- Testing Off Commands ---");
        remoteControl.offButtonPressed(0); // Living room light off
        remoteControl.offButtonPressed(1); // Kitchen light off
        
        // Create and test macro command
        System.out.println("\n--- Testing Macro Command ---");
        Command[] partyOn = {livingRoomLightOn, stereoOnWithCD, garageDoorOpen};
        Command[] partyOff = {livingRoomLightOff, stereoOff, garageDoorClose};
        
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);
        
        remoteControl.setCommand(6, partyOnMacro, partyOffMacro);
        
        System.out.println("Executing Party Mode ON:");
        remoteControl.onButtonPressed(6);
        
        System.out.println("\nUndo Party Mode:");
        remoteControl.undoButtonPressed();
        
        System.out.println("\n=== Demo Complete ===");
    }
}