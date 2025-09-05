package behavioral_design_patterns.chain_of_responsibility_pattern.example;

public class Level1Support extends SupportHandler {
    @Override
    public void handleTicket(SupportTicket ticket) {
        if (ticket.getPriority() >= 1 && ticket.getPriority() <= 3) {
            System.out.println("Level 1 Support handled: " + ticket);
        } else {
            System.out.println("Level 1 Support cannot handle priority " + ticket.getPriority() + 
                             ", passing to next level...");
            passToNext(ticket);
        }
    }
}