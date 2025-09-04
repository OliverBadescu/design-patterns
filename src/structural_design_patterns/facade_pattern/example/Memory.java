package structural_design_patterns.facade_pattern.example;

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory: Loading " + data.length + " bytes from position " + position);
    }
    
    public void initialize() {
        System.out.println("Memory: Initializing memory modules");
    }
    
    public void checkMemory() {
        System.out.println("Memory: Running memory diagnostics");
    }
}