package structural_design_patterns.facade_pattern.example;

public class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive: Reading " + size + " bytes from sector " + lba);
        return new byte[size];
    }
    
    public void spinUp() {
        System.out.println("HardDrive: Spinning up drive");
    }
    
    public void calibrate() {
        System.out.println("HardDrive: Calibrating read/write heads");
    }
}