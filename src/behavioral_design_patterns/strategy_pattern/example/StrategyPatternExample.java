package behavioral_design_patterns.strategy_pattern.example;

public class StrategyPatternExample {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Payment Strategy Pattern Demo ===");
        
        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();
        
        System.out.println("\n--- Building Shopping Cart ---");
        cart.addItem(new Item("Laptop", 999.99, "Electronics"));
        cart.addItem(new Item("Wireless Mouse", 29.99, "Electronics"));
        cart.addItem(new Item("Programming Book", 45.50, "Books"));
        cart.addItem(new Item("Coffee Mug", 12.99, "Home"));
        
        cart.displayCart();
        
        System.out.println("\n--- Scenario 1: Credit Card Payment ---");
        PaymentStrategy creditCard = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/25");
        cart.setPaymentStrategy(creditCard);
        cart.checkout();
        
        System.out.println("\n--- Adding Items for Next Purchase ---");
        cart.addItem(new Item("Smartphone", 699.99, "Electronics"));
        cart.addItem(new Item("Phone Case", 19.99, "Accessories"));
        cart.applyDiscount(0.10); // 10% discount
        
        System.out.println("\n--- Scenario 2: PayPal Payment ---");
        PaymentStrategy paypal = new PayPalPayment("john.doe@email.com", "securepassword");
        cart.setPaymentStrategy(paypal);
        cart.checkout();
        
        System.out.println("\n--- Adding High-Value Items ---");
        cart.addItem(new Item("Gaming Desktop", 1599.99, "Electronics"));
        cart.addItem(new Item("4K Monitor", 299.99, "Electronics"));
        cart.addItem(new Item("Mechanical Keyboard", 129.99, "Electronics"));
        cart.applyDiscount(0.05); // 5% discount
        
        System.out.println("\n--- Scenario 3: Cryptocurrency Payment ---");
        PaymentStrategy crypto = new CryptocurrencyPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "Bitcoin", "L1aW4aubDFB7yfras2S1mN3bqg9nwySY8nkoLsHDNtdLtKUNfB6R");
        cart.setPaymentStrategy(crypto);
        cart.checkout();
        
        System.out.println("\n--- Adding Items for Bank Transfer ---");
        cart.addItem(new Item("Office Chair", 199.99, "Furniture"));
        cart.addItem(new Item("Desk Lamp", 39.99, "Furniture"));
        
        System.out.println("\n--- Scenario 4: Bank Transfer Payment ---");
        PaymentStrategy bankTransfer = new BankTransferPayment("12345678", "123456789", "First National Bank");
        cart.setPaymentStrategy(bankTransfer);
        cart.checkout();
        
        System.out.println("\n--- Scenario 5: Payment Failure Demonstration ---");
        cart.addItem(new Item("Tablet", 329.99, "Electronics"));
        
        // Create invalid credit card
        PaymentStrategy invalidCard = new CreditCardPayment("123", "Jane Smith", "12", "01/22");
        cart.setPaymentStrategy(invalidCard);
        boolean success = cart.checkout();
        
        if (!success) {
            System.out.println("\n--- Retrying with Valid Payment Method ---");
            PaymentStrategy validPaypal = new PayPalPayment("jane.smith@email.com", "validpassword123");
            cart.setPaymentStrategy(validPaypal);
            cart.checkout();
        }
        
        System.out.println("\n--- Scenario 6: Strategy Switching at Runtime ---");
        cart.addItem(new Item("Headphones", 149.99, "Electronics"));
        cart.addItem(new Item("USB Cable", 9.99, "Electronics"));
        
        System.out.println("\nCustomer changes mind about payment method...");
        cart.setPaymentStrategy(new CreditCardPayment("9876543210987654", "Alice Johnson", "456", "06/26"));
        System.out.println("Actually, let me use crypto instead...");
        cart.setPaymentStrategy(new CryptocurrencyPayment("3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy", "Ethereum", "0x742d35Cc6634C0532925a3b8D1b5ce6b5A7b5b2A"));
        cart.checkout();
        
        System.out.println("\n--- Scenario 7: Empty Cart Checkout ---");
        cart.checkout(); // Should fail with empty cart
        
        System.out.println("\n--- Demonstrating Strategy Pattern Benefits ---");
        System.out.println("Algorithm Flexibility: Multiple payment algorithms encapsulated");
        System.out.println("Runtime Selection: Payment method chosen at runtime");
        System.out.println("Easy Extension: New payment methods can be added without changing existing code");
        System.out.println("Open/Closed Principle: Open for extension, closed for modification");
        System.out.println("Eliminates Conditionals: No if/else chains for different payment types");
        System.out.println("Single Responsibility: Each strategy handles one payment method");
        
        System.out.println("\n--- Strategy Comparison ---");
        System.out.println("Credit Card: Fast processing, wide acceptance, fees");
        System.out.println("PayPal: Secure, convenient, may have account limitations");
        System.out.println("Cryptocurrency: Decentralized, anonymous, volatile, slower confirmation");
        System.out.println("Bank Transfer: Direct, secure, slower processing, lower fees");
        
        System.out.println("\n=== Demo Complete ===");
    }
}