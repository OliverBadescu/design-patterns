package behavioral_design_patterns.strategy_pattern.example;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;
    
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing PayPal payment...")
        System.out.println("Email: " + email);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        
        // Simulate authentication and payment processing
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Simulate validation
        if (email.contains("@") && password.length() >= 6) {
            System.out.println("PayPal payment successful!")
            return true;
        } else {
            System.out.println("PayPal payment failed - Invalid credentials")
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}