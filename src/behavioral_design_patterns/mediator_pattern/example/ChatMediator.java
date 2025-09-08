package behavioral_design_patterns.mediator_pattern.example;

public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
    void removeUser(User user);
}