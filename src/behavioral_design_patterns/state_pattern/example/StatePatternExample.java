package behavioral_design_patterns.state_pattern.example;

public class StatePatternExample {
    public static void main(String[] args) {
        System.out.println("=== Vending Machine State Pattern Demo ===");
        
        // Create vending machine with 3 products
        VendingMachine vendingMachine = new VendingMachine(3);
        
        System.out.println("\n--- Initial State ---");
        System.out.println("Current state: " + vendingMachine.getStateName());
        System.out.println("Products available: " + vendingMachine.getProductCount());
        
        System.out.println("\n--- Scenario 1: Normal Purchase Flow ---");
        vendingMachine.insertCoin();
        vendingMachine.selectProduct("Coca Cola");
        vendingMachine.dispenseProduct();
        
        System.out.println("\n--- Scenario 2: Try to Select Without Coin ---");
        vendingMachine.selectProduct("Pepsi");
        
        System.out.println("\n--- Scenario 3: Insert Coin and Eject It ---");
        vendingMachine.insertCoin();
        vendingMachine.ejectCoin();
        
        System.out.println("\n--- Scenario 4: Another Normal Purchase ---");
        vendingMachine.insertCoin();
        vendingMachine.selectProduct("Sprite");
        vendingMachine.dispenseProduct();
        
        System.out.println("\n--- Scenario 5: Try Double Coin Insert ---");
        vendingMachine.insertCoin();
        vendingMachine.insertCoin(); // Should reject second coin
        vendingMachine.selectProduct("Water");
        vendingMachine.dispenseProduct();
        
        System.out.println("\n--- Scenario 6: Machine Goes Out of Stock ---");
        System.out.println("Current state: " + vendingMachine.getStateName());
        System.out.println("Products remaining: " + vendingMachine.getProductCount());
        
        System.out.println("\n--- Scenario 7: Try Operations on Empty Machine ---");
        vendingMachine.insertCoin();
        vendingMachine.selectProduct("Any Product");
        vendingMachine.ejectCoin();
        
        System.out.println("\n--- Creating New Machine to Demonstrate More Scenarios ---");
        VendingMachine newMachine = new VendingMachine(2);
        
        System.out.println("\n--- Scenario 8: Interrupt Transaction with Eject ---");
        newMachine.insertCoin();
        newMachine.selectProduct("Candy");
        newMachine.ejectCoin(); // Should not allow ejection during transaction
        newMachine.dispenseProduct(); // Complete the transaction
        
        System.out.println("\n--- Scenario 9: Multiple State Transitions ---");
        newMachine.insertCoin();
        newMachine.selectProduct("Chocolate");
        newMachine.dispenseProduct();
        
        System.out.println("\n--- Demonstrating State Pattern Benefits ---");
        System.out.println("✅ Clean State Management: Each state handles its own behavior");
        System.out.println("✅ No Complex Conditionals: Behavior is encapsulated in state classes");
        System.out.println("✅ Easy to Extend: New states can be added without modifying existing code");
        System.out.println("✅ State Transitions: Clear and controlled state changes");
        System.out.println("✅ Polymorphism: Same interface, different implementations per state");
        
        System.out.println("\n--- Final Machine States ---");
        System.out.println("First machine state: " + vendingMachine.getStateName());
        System.out.println("First machine products: " + vendingMachine.getProductCount());
        System.out.println("Second machine state: " + newMachine.getStateName());
        System.out.println("Second machine products: " + newMachine.getProductCount());
        
        System.out.println("\n=== Demo Complete ===");
    }
}