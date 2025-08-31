package factory_pattern.example;

public class VehicleExample {
    public static void main(String[] args) {
        String[] vehicleTypes = {"car", "motorcycle", "truck"};
        
        System.out.println("Factory Pattern Example - Vehicle Factory");
        System.out.println("========================================");
        
        for (String vehicleType : vehicleTypes) {
            try {
                Vehicle vehicle = VehicleFactory.createVehicle(vehicleType);
                System.out.println("\nCreated: " + vehicle.getInfo());
                System.out.println("  " + vehicle.startEngine());
                System.out.println("  " + vehicle.stopEngine());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}