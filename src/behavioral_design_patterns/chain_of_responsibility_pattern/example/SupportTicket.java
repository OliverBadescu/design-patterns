package behavioral_design_patterns.chain_of_responsibility_pattern.example;

public class SupportTicket {
    private String description;
    private int priority;
    
    public SupportTicket(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getPriority() {
        return priority;
    }
    
    @Override
    public String toString() {
        return "Ticket: " + description + " (Priority: " + priority + ")";
    }
}