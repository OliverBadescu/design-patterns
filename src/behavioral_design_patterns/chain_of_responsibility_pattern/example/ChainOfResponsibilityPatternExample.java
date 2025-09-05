package behavioral_design_patterns.chain_of_responsibility_pattern.example;

public class ChainOfResponsibilityPatternExample {
    public static void main(String[] args) {
        // Create handlers
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();
        
        // Build the chain: Level1 -> Level2 -> Level3
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);
        
        // Create various support tickets
        SupportTicket[] tickets = {
            new SupportTicket("Password reset request", 2),
            new SupportTicket("Software installation issue", 5),
            new SupportTicket("Critical system failure", 9),
            new SupportTicket("General inquiry", 1),
            new SupportTicket("Database corruption", 8),
            new SupportTicket("Invalid priority ticket", 15) // This won't be handled
        };
        
        System.out.println("=== Support Ticket Processing ===");
        System.out.println();
        
        // Process each ticket through the chain
        for (SupportTicket ticket : tickets) {
            System.out.println("Processing: " + ticket);
            level1.handleTicket(ticket);
            System.out.println();
        }
        
        System.out.println("=== Chain Processing Complete ===");
    }
}