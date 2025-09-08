package behavioral_design_patterns.mediator_pattern.example;

public class AdminUser extends User {
    
    public AdminUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }
    
    @Override
    public void send(String message) {
        System.out.println("🛡️ " + name + " (Admin) is sending: " + message);
        mediator.sendMessage("👑 [ADMIN] " + message, this);
    }
    
    @Override
    public void receive(String message) {
        System.out.println("📥 " + name + " (Admin) received: " + message);
    }
    
    public void sendSystemAnnouncement(String announcement) {
        System.out.println("📢 " + name + " (Admin) is making system announcement: " + announcement);
        mediator.sendMessage("🚨 [SYSTEM ANNOUNCEMENT] " + announcement, this);
    }
}