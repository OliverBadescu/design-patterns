package behavioral_design_patterns.template_pattern.example;

public class CSVDataProcessor extends DataProcessor {
    
    private String fileName;
    private String data;
    
    public CSVDataProcessor(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    protected void loadData() {
        System.out.println("Loading data from CSV file: " + fileName);
        data = "id,name,age\n1,John,25\n2,Jane,30\n3,Bob,35";
        System.out.println("CSV data loaded successfully");
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating CSV data format...");
        if (data == null || data.isEmpty()) {
            throw new RuntimeException("CSV data is empty or null");
        }
        String[] lines = data.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] fields = lines[i].split(",");
            if (fields.length != 3) {
                throw new RuntimeException("Invalid CSV format at line " + (i + 1));
            }
        }
        System.out.println("CSV data validation passed");
    }
    
    @Override
    protected void transformData() {
        System.out.println("Transforming CSV data to uppercase...");
        String[] lines = data.split("\n");
        StringBuilder transformedData = new StringBuilder();
        
        transformedData.append(lines[0].toUpperCase()).append("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] fields = lines[i].split(",");
            transformedData.append(fields[0]).append(",")
                           .append(fields[1].toUpperCase()).append(",")
                           .append(fields[2]).append("\n");
        }
        
        data = transformedData.toString().trim();
        System.out.println("CSV data transformation completed");
    }
    
    @Override
    protected void saveData() {
        System.out.println("Saving transformed CSV data to: " + fileName.replace(".csv", "_processed.csv"));
        System.out.println("Processed data:\n" + data);
        System.out.println("CSV data saved successfully");
    }
    
    @Override
    protected void cleanup() {
        System.out.println("Cleaning up CSV processing resources...");
        data = null;
        super.cleanup();
    }
}