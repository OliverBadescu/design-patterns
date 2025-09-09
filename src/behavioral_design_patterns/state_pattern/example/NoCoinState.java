package behavioral_design_patterns.state_pattern.example;

public class NoCoinState implements State {
    
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin accepted! You can now select a product.");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }
    
    @Override
    public void ejectCoin(VendingMachine vendingMachine) {
        System.out.println("No coin to eject. Please insert a coin first.");
    }
    
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Please insert a coin first before selecting a product.");
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense product. No coin inserted.");
    }
}