package structural_design_patterns.facade_pattern.example;

public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private GraphicsCard graphicsCard;
    
    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
        this.graphicsCard = new GraphicsCard();
    }
    
    public void start() {
        System.out.println("ComputerFacade: Starting computer...");
        System.out.println("================================");
        
        // Initialize graphics first for visual feedback
        graphicsCard.initialize();
        graphicsCard.loadDrivers();
        graphicsCard.displayBootScreen();
        
        // Initialize memory
        memory.initialize();
        memory.checkMemory();
        
        // Prepare hard drive
        hardDrive.spinUp();
        hardDrive.calibrate();
        
        // Load boot sector
        byte[] bootData = hardDrive.read(0, 1024);
        memory.load(0, bootData);
        
        // Start CPU
        cpu.freeze();
        cpu.jump(0);
        cpu.execute();
        
        // Set display resolution
        graphicsCard.setResolution(1920, 1080);
        
        System.out.println("================================");
        System.out.println("ComputerFacade: Computer started successfully!");
    }
    
    public void shutdown() {
        System.out.println("\nComputerFacade: Shutting down computer...");
        System.out.println("=======================================");
        System.out.println("CPU: Halting processor");
        System.out.println("Memory: Clearing memory");
        System.out.println("HardDrive: Parking read/write heads");
        System.out.println("GraphicsCard: Turning off display");
        System.out.println("=======================================");
        System.out.println("ComputerFacade: Computer shut down successfully!");
    }
}