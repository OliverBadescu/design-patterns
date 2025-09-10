package behavioral_design_patterns.template_pattern.example;

public class TemplatePatternExample {
    public static void main(String[] args) {
        System.out.println("=== Template Pattern Example ===");
        System.out.println("Demonstrating data processing workflow with different file formats");
        System.out.println();
        
        System.out.println("1. Processing CSV Data:");
        System.out.println("========================");
        DataProcessor csvProcessor = new CSVDataProcessor("users.csv");
        csvProcessor.processData();
        
        System.out.println();
        System.out.println("2. Processing XML Data:");
        System.out.println("========================");
        DataProcessor xmlProcessor = new XMLDataProcessor("users.xml");
        xmlProcessor.processData();
        
        System.out.println();
        System.out.println("3. Processing JSON Data:");
        System.out.println("=========================");
        DataProcessor jsonProcessor = new JSONDataProcessor("users.json");
        jsonProcessor.processData();
        
        System.out.println();
        System.out.println("=== Template Pattern Benefits Demonstrated ===");
        System.out.println("- Same workflow (load → validate → transform → save → cleanup) for all formats");
        System.out.println("- Each processor implements format-specific logic");
        System.out.println("- Common structure prevents missing steps");
        System.out.println("- Easy to add new data formats without changing existing code");
    }
}