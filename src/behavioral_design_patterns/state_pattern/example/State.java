package behavioral_design_patterns.state_pattern.example;

public interface State {
    void insertCoin(VendingMachine vendingMachine);
    void ejectCoin(VendingMachine vendingMachine);
    void selectProduct(VendingMachine vendingMachine);
    void dispenseProduct(VendingMachine vendingMachine);
}