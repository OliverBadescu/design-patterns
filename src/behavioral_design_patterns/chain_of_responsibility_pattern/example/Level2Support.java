package behavioral_design_patterns.chain_of_responsibility_pattern.example;

public class Level2Support extends SupportHandler {
    @Override
    public void handleTicket(SupportTicket ticket) {
        if (ticket.getPriority() >= 4 && ticket.getPriority() <= 6) {
            System.out.println("Level 2 Support handled: " + ticket);
        } else {
            System.out.println("Level 2 Support cannot handle priority " + ticket.getPriority() + 
                             ", passing to next level...");
            passToNext(ticket);
        }
    }
}