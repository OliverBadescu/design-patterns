package behavioral_design_patterns.chain_of_responsibility_pattern.example;

public class Level3Support extends SupportHandler {
    @Override
    public void handleTicket(SupportTicket ticket) {
        if (ticket.getPriority() >= 7 && ticket.getPriority() <= 10) {
            System.out.println("Level 3 Support handled: " + ticket);
        } else {
            System.out.println("Level 3 Support cannot handle priority " + ticket.getPriority() + 
                             ", passing to next level...");
            passToNext(ticket);
        }
    }
}