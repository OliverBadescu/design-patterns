package abstract_factory_pattern.example;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        System.out.println("Abstract Factory Pattern Example - Vehicle Components");
        System.out.println("====================================================");
        
        VehicleComponentFactory[] factories = {
            new EconomyVehicleFactory(),
            new LuxuryVehicleFactory()
        };
        
        String[] factoryTypes = {"Economy Vehicle", "Luxury Vehicle"};
        
        for (int i = 0; i < factories.length; i++) {
            System.out.println("\n" + factoryTypes[i] + " Factory:");
            System.out.println("-".repeat(factoryTypes[i].length() + 9));
            
            VehicleComponentFactory factory = factories[i];
            
            Engine engine = factory.createEngine();
            Wheel wheel = factory.createWheel();
            
            System.out.println("Engine: " + engine.getType());
            System.out.println("  " + engine.start());
            System.out.println("  " + engine.stop());
            
            System.out.println("Wheel: " + wheel.getType());
            System.out.println("  Size: " + wheel.getSize());
            System.out.println("  Material: " + wheel.getMaterial());
        }
        
        System.out.println("\nDemonstrating factory families working together:");
        System.out.println("===============================================");
        
        System.out.println("\nBuilding an Economy Vehicle:");
        buildVehicle(new EconomyVehicleFactory());
        
        System.out.println("\nBuilding a Luxury Vehicle:");
        buildVehicle(new LuxuryVehicleFactory());
    }
    
    private static void buildVehicle(VehicleComponentFactory factory) {
        Engine engine = factory.createEngine();
        Wheel wheel = factory.createWheel();
        
        System.out.println("  Installing " + engine.getType());
        System.out.println("  Installing " + wheel.getType() + " (" + wheel.getSize() + ")");
        System.out.println("  Vehicle assembly complete!");
    }
}