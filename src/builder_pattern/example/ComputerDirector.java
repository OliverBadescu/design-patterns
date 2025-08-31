package builder_pattern.example;

public class ComputerDirector {
    
    public static Computer buildGamingComputer() {
        return new Computer.ComputerBuilder("Intel i9-13900K", "32GB DDR5")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setPowerSupply("850W Gold")
                .enableWiFi()
                .enableBluetooth()
                .build();
    }
    
    public static Computer buildOfficeComputer() {
        return new Computer.ComputerBuilder("Intel i5-13400", "16GB DDR4")
                .setStorage("512GB SSD")
                .enableWiFi()
                .build();
    }
    
    public static Computer buildBudgetComputer() {
        return new Computer.ComputerBuilder("AMD Ryzen 5 5600G", "8GB DDR4")
                .setStorage("256GB SSD")
                .build();
    }
    
    public static Computer buildWorkstationComputer() {
        return new Computer.ComputerBuilder("AMD Ryzen 9 7950X", "64GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX A5000")
                .setPowerSupply("1000W Platinum")
                .enableWiFi()
                .enableBluetooth()
                .build();
    }
}