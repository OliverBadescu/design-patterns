package behavioral_design_patterns.strategy_pattern.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;
    private double discountPercentage;
    private double taxRate;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.discountPercentage = 0.0;
        this.taxRate = 0.08; // 8% tax rate
    }
    
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added to cart: " + item.getName() + " - $" + String.format("%.2f", item.getPrice()));
    }
    
    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equals(itemName));
        System.out.println("Removed from cart: " + itemName);
    }
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("Payment method set to: " + paymentStrategy.getPaymentMethod());
    }
    
    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
        System.out.println("Discount applied: " + (discountPercentage * 100) + "%");
    }
    
    public double calculateSubtotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
    
    public double calculateDiscount() {
        return calculateSubtotal() * discountPercentage;
    }
    
    public double calculateTax() {
        return (calculateSubtotal() - calculateDiscount()) * taxRate;
    }
    
    public double calculateTotal() {
        return calculateSubtotal() - calculateDiscount() + calculateTax();
    }
    
    public void displayCart() {
        System.out.println("\n=== Shopping Cart Summary ===");
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        
        for (Item item : items) {
            System.out.println("• " + item.getName() + " - $" + String.format("%.2f", item.getPrice()));
        }
        
        System.out.println("────────────────────────────────");
        System.out.println("Subtotal: $" + String.format("%.2f", calculateSubtotal()));
        if (discountPercentage > 0) {
            System.out.println("Discount (" + (discountPercentage * 100) + "%): -$" + String.format("%.2f", calculateDiscount()));
        }
        System.out.println("Tax (" + (taxRate * 100) + "%): $" + String.format("%.2f", calculateTax()));
        System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
        System.out.println("════════════════════════════════");
    }
    
    public boolean checkout() {
        if (items.isEmpty()) {
            System.out.println("Cannot checkout - cart is empty");
            return false;
        }
        
        if (paymentStrategy == null) {
            System.out.println("Cannot checkout - no payment method selected");
            return false;
        }
        
        displayCart();
        System.out.println("\nProcessing checkout...");
        
        double totalAmount = calculateTotal();
        boolean paymentSuccessful = paymentStrategy.pay(totalAmount);
        
        if (paymentSuccessful) {
            System.out.println("Order completed successfully!");
            System.out.println("Your items will be shipped soon.");
            items.clear();
            discountPercentage = 0.0;
            return true;
        } else {
            System.out.println("Checkout failed - payment was not processed");
            return false;
        }
    }
    
    public int getItemCount() {
        return items.size();
    }
    
    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}