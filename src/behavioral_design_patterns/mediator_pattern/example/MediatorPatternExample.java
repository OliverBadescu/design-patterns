package behavioral_design_patterns.mediator_pattern.example;

public class MediatorPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Chat Room Application Demo ===");
        
        // Create chat rooms (mediators)
        ChatRoom generalChat = new ChatRoom("General Chat");
        ChatRoom gamingChat = new ChatRoom("Gaming Chat");
        
        // Create different types of users
        RegularUser alice = new RegularUser(generalChat, "Alice");
        RegularUser bob = new RegularUser(generalChat, "Bob");
        PremiumUser charlie = new PremiumUser(generalChat, "Charlie");
        AdminUser admin = new AdminUser(generalChat, "AdminMike");
        
        RegularUser dave = new RegularUser(gamingChat, "Dave");
        PremiumUser eve = new PremiumUser(gamingChat, "Eve");
        
        System.out.println("\n--- Adding Users to General Chat ---");
        generalChat.addUser(alice);
        generalChat.addUser(bob);
        generalChat.addUser(charlie);
        generalChat.addUser(admin);
        
        System.out.println("\n--- Adding Users to Gaming Chat ---");
        gamingChat.addUser(dave);
        gamingChat.addUser(eve);
        
        // Show active users
        generalChat.showActiveUsers();
        gamingChat.showActiveUsers();
        
        System.out.println("\n--- General Chat Conversation ---");
        alice.send("Hey everyone! How's it going?");
        
        System.out.println();
        bob.send("Pretty good! Working on some Java code.");
        
        System.out.println();
        charlie.send("Nice! I'm learning design patterns right now.");
        
        System.out.println();
        admin.sendSystemAnnouncement("Server maintenance scheduled for tonight at 2 AM");
        
        System.out.println("\n--- Gaming Chat Conversation ---");
        dave.send("Anyone up for a game of chess?");
        
        System.out.println();
        eve.send("I'm in! Let's start a match.");
        
        System.out.println("\n--- User Leaving General Chat ---");
        generalChat.removeUser(bob);
        
        System.out.println();
        alice.send("Where did Bob go?");
        
        System.out.println();
        charlie.send("He probably had to leave for a meeting.");
        
        System.out.println("\n--- Final User Counts ---");
        System.out.println("👥 " + generalChat.getRoomName() + " has " + generalChat.getUserCount() + " users");
        System.out.println("👥 " + gamingChat.getRoomName() + " has " + gamingChat.getUserCount() + " users");
        
        System.out.println("\n--- Demonstrating Mediator Benefits ---");
        System.out.println("✅ Users don't need to know about each other");
        System.out.println("✅ Central communication management through ChatRoom");
        System.out.println("✅ Easy to add new user types without changing existing code");
        System.out.println("✅ Broadcasting logic is centralized and reusable");
        System.out.println("✅ Different chat rooms can have different behaviors");
        
        System.out.println("\n=== Demo Complete ===");
    }
}