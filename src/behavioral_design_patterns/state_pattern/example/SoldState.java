package behavioral_design_patterns.state_pattern.example;

public class SoldState implements State {
    
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("⏳ Please wait, currently dispensing product...");
    }
    
    @Override
    public void ejectCoin(VendingMachine vendingMachine) {
        System.out.println("❌ Cannot eject coin. Transaction in progress.");
    }
    
    @Override
    public void selectProduct(VendingMachine vendingMachine) {
        System.out.println("⏳ Please wait, currently dispensing selected product...");
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("🎁 Dispensing product...");
        vendingMachine.dispenseProduct();
    }
}