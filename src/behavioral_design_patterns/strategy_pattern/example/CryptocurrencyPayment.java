package behavioral_design_patterns.strategy_pattern.example;

public class CryptocurrencyPayment implements PaymentStrategy {
    private String walletAddress;
    private String cryptoType;
    private String privateKey;
    
    public CryptocurrencyPayment(String walletAddress, String cryptoType, String privateKey) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
        this.privateKey = privateKey;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing " + cryptoType + " payment...")
        System.out.println("Wallet Address: " + walletAddress.substring(0, 6) + "..." + walletAddress.substring(walletAddress.length() - 6));
        System.out.println("Amount: $" + String.format("%.2f", amount) + " (" + cryptoType + ")");
        
        // Simulate blockchain transaction processing
        System.out.println("Broadcasting transaction to blockchain...")
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Simulate validation
        if (walletAddress.length() >= 26 && privateKey.length() >= 32) {
            System.out.println(cryptoType + " payment successful! Transaction confirmed.")
            return true;
        } else {
            System.out.println(cryptoType + " payment failed - Invalid wallet or key")
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return cryptoType + " Cryptocurrency";
    }
}