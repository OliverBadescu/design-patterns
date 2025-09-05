package behavioral_design_patterns.chain_of_responsibility_pattern.example;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;
    
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public abstract void handleTicket(SupportTicket ticket);
    
    protected void passToNext(SupportTicket ticket) {
        if (nextHandler != null) {
            nextHandler.handleTicket(ticket);
        } else {
            System.out.println("No handler available for: " + ticket);
        }
    }
}