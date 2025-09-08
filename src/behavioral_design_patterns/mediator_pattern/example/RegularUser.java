package behavioral_design_patterns.mediator_pattern.example;

public class RegularUser extends User {
    
    public RegularUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }
    
    @Override
    public void send(String message) {
        System.out.println("💬 " + name + " is sending: " + message);
        mediator.sendMessage(message, this);
    }
    
    @Override
    public void receive(String message) {
        System.out.println("📥 " + name + " received: " + message);
    }
}