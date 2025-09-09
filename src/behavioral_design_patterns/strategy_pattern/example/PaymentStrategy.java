package behavioral_design_patterns.strategy_pattern.example;

public interface PaymentStrategy {
    boolean pay(double amount);
    String getPaymentMethod();
}