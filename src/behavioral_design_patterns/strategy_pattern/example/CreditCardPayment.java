package behavioral_design_patterns.strategy_pattern.example;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;
    private String cvv;
    private String expiryDate;
    
    public CreditCardPayment(String cardNumber, String cardHolder, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing credit card payment...")
        System.out.println("Card Number: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        
        // Simulate payment processing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Simulate validation
        if (cardNumber.length() == 16 && cvv.length() == 3) {
            System.out.println("Credit card payment successful!")
            return true;
        } else {
            System.out.println("Credit card payment failed - Invalid card details")
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}