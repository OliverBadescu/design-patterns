package behavioral_design_patterns.strategy_pattern.example;

public class BankTransferPayment implements PaymentStrategy {
    private String accountNumber;
    private String routingNumber;
    private String bankName;
    
    public BankTransferPayment(String accountNumber, String routingNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
        this.bankName = bankName;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing bank transfer payment...")
        System.out.println("Bank: " + bankName);
        System.out.println("Account: **** **** " + accountNumber.substring(accountNumber.length() - 4));
        System.out.println("Amount: $" + String.format("%.2f", amount));
        
        // Simulate bank processing time
        System.out.println("Contacting bank for authorization...")
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Simulate validation
        if (accountNumber.length() >= 8 && routingNumber.length() == 9) {
            System.out.println("Bank transfer payment successful!")
            System.out.println("Confirmation email sent with transaction details")
            return true;
        } else {
            System.out.println("Bank transfer failed - Invalid account or routing number")
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}