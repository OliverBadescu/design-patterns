package structural_design_patterns.facade_pattern.example;

public class FacadePatternExample {
    public static void main(String[] args) {
        System.out.println("Facade Pattern Example - Computer System");
        System.out.println("=======================================");
        
        // Without facade, client would need to interact with all subsystems directly
        System.out.println("\n--- Complex way (without facade) ---");
        demonstrateWithoutFacade();
        
        System.out.println("\n\n--- Simple way (with facade) ---");
        demonstrateWithFacade();
    }
    
    private static void demonstrateWithoutFacade() {
        System.out.println("Client needs to manage all subsystems manually:");
        
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
        GraphicsCard graphicsCard = new GraphicsCard();
        
        // Client must know the correct order and all the steps
        System.out.println("- Manually initializing graphics...");
        graphicsCard.initialize();
        graphicsCard.loadDrivers();
        
        System.out.println("- Manually preparing memory...");
        memory.initialize();
        
        System.out.println("- Manually starting hard drive...");
        hardDrive.spinUp();
        
        System.out.println("- And many more complex steps...");
        System.out.println("(This is error-prone and complex for the client)");
    }
    
    private static void demonstrateWithFacade() {
        System.out.println("Client uses simple facade interface:");
        
        // With facade, client interaction is simple
        ComputerFacade computer = new ComputerFacade();
        
        // Single method call handles all complexity
        computer.start();
        
        // Simulate some work
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Single method call for shutdown
        computer.shutdown();
    }
}