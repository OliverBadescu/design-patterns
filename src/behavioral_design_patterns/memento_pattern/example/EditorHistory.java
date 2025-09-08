package behavioral_design_patterns.memento_pattern.example;

import java.util.ArrayList;
import java.util.List;

public class EditorHistory {
    private List<TextEditorMemento> history;
    private int currentPosition;
    private final int maxHistorySize;
    
    public EditorHistory() {
        this(50); // Default max history size
    }
    
    public EditorHistory(int maxHistorySize) {
        this.history = new ArrayList<>();
        this.currentPosition = -1;
        this.maxHistorySize = maxHistorySize;
    }
    
    public void save(TextEditorMemento memento) {
        // Remove any "future" states if we're not at the end
        if (currentPosition < history.size() - 1) {
            history = history.subList(0, currentPosition + 1);
        }
        
        history.add(memento);
        currentPosition++;
        
        // Maintain maximum history size
        if (history.size() > maxHistorySize) {
            history.remove(0);
            currentPosition--;
        }
        
        System.out.println("💾 Saved state: " + memento.toString());
    }
    
    public TextEditorMemento undo() {
        if (canUndo()) {
            currentPosition--;
            TextEditorMemento memento = history.get(currentPosition);
            System.out.println("↶ Undo to: " + memento.toString());
            return memento;
        }
        System.out.println("❌ Nothing to undo");
        return null;
    }
    
    public TextEditorMemento redo() {
        if (canRedo()) {
            currentPosition++;
            TextEditorMemento memento = history.get(currentPosition);
            System.out.println("↷ Redo to: " + memento.toString());
            return memento;
        }
        System.out.println("❌ Nothing to redo");
        return null;
    }
    
    public boolean canUndo() {
        return currentPosition > 0;
    }
    
    public boolean canRedo() {
        return currentPosition < history.size() - 1;
    }
    
    public void showHistory() {
        System.out.println("\n📚 Editor History:");
        if (history.isEmpty()) {
            System.out.println("  (No history available)");
            return;
        }
        
        for (int i = 0; i < history.size(); i++) {
            String indicator = (i == currentPosition) ? "👉 " : "   ";
            System.out.println(indicator + (i + 1) + ". " + history.get(i).toString());
        }
    }
    
    public int getHistorySize() {
        return history.size();
    }
    
    public int getCurrentPosition() {
        return currentPosition;
    }
    
    public void clear() {
        history.clear();
        currentPosition = -1;
        System.out.println("🗑️ History cleared");
    }
}