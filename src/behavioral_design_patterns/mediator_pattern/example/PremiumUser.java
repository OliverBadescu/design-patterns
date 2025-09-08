package behavioral_design_patterns.mediator_pattern.example;

public class PremiumUser extends User {
    
    public PremiumUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }
    
    @Override
    public void send(String message) {
        System.out.println("✨ " + name + " (Premium) is sending: " + message);
        mediator.sendMessage("⭐ " + message, this);
    }
    
    @Override
    public void receive(String message) {
        System.out.println("📥 " + name + " (Premium) received: " + message);
    }
}