package behavioral_design_patterns.state_pattern.example;

public class HasCoinState implements State {
    
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin already inserted. Please select a product or eject the current coin.");
    }
    
    @Override
    public void ejectCoin(VendingMachine vendingMachine) {
        System.out.println("Coin ejected! Thank you.");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }
    
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("Product selected: " + vendingMachine.getSelectedProduct());
        System.out.println("Processing payment...");
        vendingMachine.setState(vendingMachine.getSoldState());
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Please select a product first.");
    }
}