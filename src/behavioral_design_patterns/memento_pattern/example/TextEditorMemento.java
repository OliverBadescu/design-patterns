package behavioral_design_patterns.memento_pattern.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextEditorMemento {
    private final String content;
    private final int cursorPosition;
    private final String timestamp;
    private final String operationDescription;
    
    public TextEditorMemento(String content, int cursorPosition, String operationDescription) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.operationDescription = operationDescription;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    public String getContent() {
        return content;
    }
    
    public int getCursorPosition() {
        return cursorPosition;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public String getOperationDescription() {
        return operationDescription;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - Content length: %d chars", 
                           timestamp, operationDescription, content.length());
    }
}