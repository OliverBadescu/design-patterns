package behavioral_design_patterns.template_pattern.example;

public class XMLDataProcessor extends DataProcessor {
    
    private String fileName;
    private String data;
    
    public XMLDataProcessor(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    protected void loadData() {
        System.out.println("Loading data from XML file: " + fileName);
        data = "<?xml version=\"1.0\"?>\n<users>\n  <user id=\"1\">\n    <name>John</name>\n    <age>25</age>\n  </user>\n  <user id=\"2\">\n    <name>Jane</name>\n    <age>30</age>\n  </user>\n</users>";
        System.out.println("XML data loaded successfully");
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating XML data structure...");
        if (data == null || data.isEmpty()) {
            throw new RuntimeException("XML data is empty or null");
        }
        if (!data.contains("<?xml version=") || !data.contains("<users>") || !data.contains("</users>")) {
            throw new RuntimeException("Invalid XML structure");
        }
        System.out.println("XML data validation passed");
    }
    
    @Override
    protected void transformData() {
        System.out.println("Transforming XML data - adding processed timestamp...");
        String timestamp = String.valueOf(System.currentTimeMillis());
        data = data.replace("</users>", 
            "  <metadata>\n    <processed_timestamp>" + timestamp + "</processed_timestamp>\n  </metadata>\n</users>");
        System.out.println("XML data transformation completed");
    }
    
    @Override
    protected void saveData() {
        System.out.println("Saving transformed XML data to: " + fileName.replace(".xml", "_processed.xml"));
        System.out.println("Processed data:\n" + data);
        System.out.println("XML data saved successfully");
    }
    
    @Override
    protected void cleanup() {
        System.out.println("Cleaning up XML processing resources...");
        data = null;
        super.cleanup();
    }
}