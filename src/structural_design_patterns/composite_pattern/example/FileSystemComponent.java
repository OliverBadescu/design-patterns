package structural_design_patterns.composite_pattern.example;

public abstract class  FileSystemComponent {
    protected String name;
    
    public FileSystemComponent(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void display(int indent);
    public abstract long getSize();
    
    // Default implementations for composite operations
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component");
    }
    
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component");
    }
    
    public FileSystemComponent getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from a leaf component");
    }
}