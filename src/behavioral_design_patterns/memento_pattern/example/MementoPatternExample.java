package behavioral_design_patterns.memento_pattern.example;

public class MementoPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Text Editor with Undo/Redo Demo ===");
        
        // Create text editor and history manager
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory(10);
        
        // Save initial empty state
        history.save(editor.createMemento("Initial empty document"));
        
        System.out.println("\n--- Creating Initial Content ---");
        editor.type("Hello World!");
        editor.displayStatus();
        history.save(editor.createMemento("Typed 'Hello World!'"));
        
        System.out.println("\n--- Adding More Content ---");
        editor.moveCursor(5); // Move to after "Hello"
        editor.type(" Beautiful");
        editor.displayStatus();
        history.save(editor.createMemento("Added ' Beautiful'"));
        
        System.out.println("\n--- Making Corrections ---");
        editor.moveCursor(editor.getContent().length()); // Move to end
        editor.type(" of Programming!");
        editor.displayStatus();
        history.save(editor.createMemento("Added ' of Programming!'"));
        
        System.out.println("\n--- Deleting Some Text ---");
        editor.moveCursor(editor.getContent().indexOf("Beautiful") + "Beautiful".length());
        editor.delete(10); // Delete " Beautiful"
        editor.displayStatus();
        history.save(editor.createMemento("Deleted ' Beautiful'"));
        
        System.out.println("\n--- Replacing Text ---");
        int startPos = editor.getContent().indexOf("World");
        editor.replaceText(startPos, startPos + "World".length(), "Java");
        editor.displayStatus();
        history.save(editor.createMemento("Replaced 'World' with 'Java'"));
        
        // Show current history
        history.showHistory();
        
        System.out.println("\n--- Testing Undo Operations ---");
        
        // Undo last operation (replace)
        TextEditorMemento memento = history.undo();
        if (memento != null) {
            editor.restoreFromMemento(memento);
            editor.displayStatus();
        }
        
        // Undo again (delete)
        memento = history.undo();
        if (memento != null) {
            editor.restoreFromMemento(memento);
            editor.displayStatus();
        }
        
        // Undo again (add "of Programming!")
        memento = history.undo();
        if (memento != null) {
            editor.restoreFromMemento(memento);
            editor.displayStatus();
        }
        
        System.out.println("\n--- Testing Redo Operations ---");
        
        // Redo last undone operation
        memento = history.redo();
        if (memento != null) {
            editor.restoreFromMemento(memento);
            editor.displayStatus();
        }
        
        // Redo again
        memento = history.redo();
        if (memento != null) {
            editor.restoreFromMemento(memento);
            editor.displayStatus();
        }
        
        System.out.println("\n--- Making New Changes (This Will Clear Redo History) ---");
        editor.type(" - Final Version");
        editor.displayStatus();
        history.save(editor.createMemento("Added ' - Final Version'"));
        
        // Show updated history
        history.showHistory();
        
        System.out.println("\n--- Testing Undo Limits ---");
        for (int i = 0; i < 15; i++) {
            memento = history.undo();
            if (memento != null) {
                editor.restoreFromMemento(memento);
                System.out.println("  Current content: \"" + editor.getContent() + "\"");
            } else {
                break;
            }
        }
        
        System.out.println("\n--- Final History State ---");
        history.showHistory();
        
        System.out.println("\n--- Demonstrating Memento Benefits ---");
        System.out.println("✅ Complete state preservation (content + cursor position)");
        System.out.println("✅ Encapsulation: Editor internals hidden in memento");
        System.out.println("✅ Flexible history management with size limits");
        System.out.println("✅ Support for both undo and redo operations");
        System.out.println("✅ Timestamps and operation descriptions for debugging");
        System.out.println("✅ History branching when new changes are made");
        
        System.out.println("\n=== Demo Complete ===");
    }
}