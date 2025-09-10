package behavioral_design_patterns.template_pattern.example;

public abstract class DataProcessor {
    
    public final void processData() {
        loadData();
        validateData();
        transformData();
        saveData();
        cleanup();
    }
    
    protected abstract void loadData();
    
    protected abstract void validateData();
    
    protected abstract void transformData();
    
    protected abstract void saveData();
    
    protected void cleanup() {
        System.out.println("Performing cleanup operations...");
    }
}