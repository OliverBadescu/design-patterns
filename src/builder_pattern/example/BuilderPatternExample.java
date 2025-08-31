package builder_pattern.example;

public class BuilderPatternExample {
    public static void main(String[] args) {
        System.out.println("Builder Pattern Example - Computer Builder");
        System.out.println("==========================================");
        
        System.out.println("\n1. Building a Custom Gaming Computer:");
        System.out.println("------------------------------------");
        Computer gamingPC = new Computer.ComputerBuilder("Intel i7-13700K", "32GB DDR5")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4070")
                .setPowerSupply("750W Gold")
                .enableWiFi()
                .enableBluetooth()
                .build();
        
        System.out.println(gamingPC);
        
        System.out.println("\n\n2. Building a Basic Office Computer:");
        System.out.println("-----------------------------------");
        Computer officePC = new Computer.ComputerBuilder("Intel i3-13100", "8GB DDR4")
                .enableWiFi()
                .build();
        
        System.out.println(officePC);
        
        System.out.println("\n\n3. Using Director to Build Predefined Computers:");
        System.out.println("-----------------------------------------------");
        
        System.out.println("\nGaming Computer (via Director):");
        Computer directorGamingPC = ComputerDirector.buildGamingComputer();
        System.out.println(directorGamingPC);
        
        System.out.println("\nOffice Computer (via Director):");
        Computer directorOfficePC = ComputerDirector.buildOfficeComputer();
        System.out.println(directorOfficePC);
        
        System.out.println("\nBudget Computer (via Director):");
        Computer budgetPC = ComputerDirector.buildBudgetComputer();
        System.out.println(budgetPC);
        
        System.out.println("\nWorkstation Computer (via Director):");
        Computer workstationPC = ComputerDirector.buildWorkstationComputer();
        System.out.println(workstationPC);
        
        System.out.println("\n\n4. Demonstrating Builder Flexibility:");
        System.out.println("------------------------------------");
        
        Computer minimalPC = new Computer.ComputerBuilder("AMD Ryzen 3 4300G", "4GB DDR4")
                .build();
        System.out.println("Minimal Computer (only required fields):");
        System.out.println(minimalPC);
        
        Computer maximalPC = new Computer.ComputerBuilder("Intel i9-13900KS", "128GB DDR5")
                .setStorage("4TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setPowerSupply("1200W Titanium")
                .enableWiFi()
                .enableBluetooth()
                .build();
        System.out.println("\nMaximal Computer (all options):");
        System.out.println(maximalPC);
    }
}