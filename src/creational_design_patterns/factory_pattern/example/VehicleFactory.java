package creational_design_patterns.factory_pattern.example;


public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car();
            case "motorcycle":
                return new Motorcycle();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}