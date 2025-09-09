package behavioral_design_patterns.state_pattern.example;

public class OutOfStockState implements State {
    
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Machine is out of stock. Cannot accept coins.");
        System.out.println("Coin returned immediately.");
    }
    
    @Override
    public void ejectCoin(VendingMachine vendingMachine) {
        System.out.println("No coin to eject. Machine is out of stock.");
    }
    
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Machine is out of stock. No products available.");
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense product. Machine is out of stock.");
    }
}