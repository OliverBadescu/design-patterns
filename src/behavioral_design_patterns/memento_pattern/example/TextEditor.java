package behavioral_design_patterns.memento_pattern.example;

public class TextEditor {
    private StringBuilder content;
    private int cursorPosition;
    
    public TextEditor() {
        this.content = new StringBuilder();
        this.cursorPosition = 0;
    }
    
    public void type(String text) {
        content.insert(cursorPosition, text);
        cursorPosition += text.length();
        System.out.println("⌨️ Typed: \"" + text + "\"");
    }
    
    public void moveCursor(int position) {
        if (position >= 0 && position <= content.length()) {
            cursorPosition = position;
            System.out.println("↔️ Cursor moved to position: " + position);
        } else {
            System.out.println("❌ Invalid cursor position: " + position);
        }
    }
    
    public void delete(int numCharacters) {
        int startPos = Math.max(0, cursorPosition - numCharacters);
        int endPos = cursorPosition;
        
        if (startPos < endPos) {
            String deletedText = content.substring(startPos, endPos);
            content.delete(startPos, endPos);
            cursorPosition = startPos;
            System.out.println("🗑️ Deleted: \"" + deletedText + "\"");
        }
    }
    
    public void replaceText(int startPos, int endPos, String newText) {
        if (startPos >= 0 && endPos <= content.length() && startPos <= endPos) {
            String oldText = content.substring(startPos, endPos);
            content.replace(startPos, endPos, newText);
            cursorPosition = startPos + newText.length();
            System.out.println("🔄 Replaced \"" + oldText + "\" with \"" + newText + "\"");
        } else {
            System.out.println("❌ Invalid replace operation");
        }
    }
    
    public void selectAll() {
        cursorPosition = content.length();
        System.out.println("📝 Selected all text");
    }
    
    public TextEditorMemento createMemento(String operationDescription) {
        return new TextEditorMemento(content.toString(), cursorPosition, operationDescription);
    }
    
    public void restoreFromMemento(TextEditorMemento memento) {
        this.content = new StringBuilder(memento.getContent());
        this.cursorPosition = memento.getCursorPosition();
        System.out.println("🔙 Restored to: " + memento.getOperationDescription());
    }
    
    public String getContent() {
        return content.toString();
    }
    
    public int getCursorPosition() {
        return cursorPosition;
    }
    
    public void displayStatus() {
        System.out.println("📄 Content: \"" + content.toString() + "\"");
        System.out.println("📍 Cursor at position: " + cursorPosition);
        System.out.println("📏 Length: " + content.length() + " characters");
    }
}