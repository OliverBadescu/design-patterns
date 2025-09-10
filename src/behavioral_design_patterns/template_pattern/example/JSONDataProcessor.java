package behavioral_design_patterns.template_pattern.example;

public class JSONDataProcessor extends DataProcessor {
    
    private String fileName;
    private String data;
    
    public JSONDataProcessor(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    protected void loadData() {
        System.out.println("Loading data from JSON file: " + fileName);
        data = "{\n  \"users\": [\n    {\n      \"id\": 1,\n      \"name\": \"John\",\n      \"age\": 25\n    },\n    {\n      \"id\": 2,\n      \"name\": \"Jane\",\n      \"age\": 30\n    }\n  ]\n}";
        System.out.println("JSON data loaded successfully");
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating JSON data format...");
        if (data == null || data.isEmpty()) {
            throw new RuntimeException("JSON data is empty or null");
        }
        if (!data.trim().startsWith("{") || !data.trim().endsWith("}")) {
            throw new RuntimeException("Invalid JSON format - must be an object");
        }
        if (!data.contains("\"users\"")) {
            throw new RuntimeException("JSON must contain 'users' array");
        }
        System.out.println("JSON data validation passed");
    }
    
    @Override
    protected void transformData() {
        System.out.println("Transforming JSON data - adding status field to users...");
        data = data.replace("\"age\": 25", "\"age\": 25,\n      \"status\": \"active\"")
                   .replace("\"age\": 30", "\"age\": 30,\n      \"status\": \"active\"");
        
        String timestamp = "\"" + System.currentTimeMillis() + "\"";
        data = data.replace("}\n}", "},\n  \"processed_at\": " + timestamp + "\n}");
        System.out.println("JSON data transformation completed");
    }
    
    @Override
    protected void saveData() {
        System.out.println("Saving transformed JSON data to: " + fileName.replace(".json", "_processed.json"));
        System.out.println("Processed data:\n" + data);
        System.out.println("JSON data saved successfully");
    }
    
    @Override
    protected void cleanup() {
        System.out.println("Cleaning up JSON processing resources...");
        data = null;
        super.cleanup();
    }
}