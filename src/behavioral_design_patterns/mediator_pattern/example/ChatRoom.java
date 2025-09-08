package behavioral_design_patterns.mediator_pattern.example;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChatRoom implements ChatMediator {
    private List<User> users;
    private String roomName;
    private DateTimeFormatter timeFormatter;
    
    public ChatRoom(String roomName) {
        this.users = new ArrayList<>();
        this.roomName = roomName;
        this.timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }
    
    @Override
    public void addUser(User user) {
        users.add(user);
        notifyUsers(user.getName() + " joined the chat room", null);
    }
    
    @Override
    public void removeUser(User user) {
        users.remove(user);
        notifyUsers(user.getName() + " left the chat room", null);
    }
    
    @Override
    public void sendMessage(String message, User sender) {
        String timestamp = LocalTime.now().format(timeFormatter);
        String formattedMessage = String.format("[%s] %s: %s", timestamp, sender.getName(), message);
        
        System.out.println("📨 Broadcasting in " + roomName + ": " + formattedMessage);
        
        for (User user : users) {
            if (user != sender) {
                user.receive(formattedMessage);
            }
        }
    }
    
    private void notifyUsers(String notification, User excludeUser) {
        String timestamp = LocalTime.now().format(timeFormatter);
        String formattedNotification = String.format("[%s] 📢 %s", timestamp, notification);
        
        System.out.println("🔔 System notification in " + roomName + ": " + formattedNotification);
        
        for (User user : users) {
            if (user != excludeUser) {
                user.receive(formattedNotification);
            }
        }
    }
    
    public void showActiveUsers() {
        System.out.println("\n👥 Active users in " + roomName + ":");
        for (User user : users) {
            System.out.println("  - " + user.getName() + " (" + user.getClass().getSimpleName() + ")");
        }
    }
    
    public int getUserCount() {
        return users.size();
    }
    
    public String getRoomName() {
        return roomName;
    }
}