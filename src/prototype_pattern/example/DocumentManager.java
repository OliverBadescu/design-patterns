package prototype_pattern.example;

import java.util.HashMap;
import java.util.Map;

public class DocumentManager {
    private Map<String, Document> documentPrototypes;
    
    public DocumentManager() {
        documentPrototypes = new HashMap<>();
        loadPrototypes();
    }
    
    private void loadPrototypes() {
        documentPrototypes.put("text", new TextDocument("Template", "Default content", "UTF-8"));
        documentPrototypes.put("pdf", new PDFDocument("Template", "Default content", false, 1));
    }
    
    public Document createDocument(String type) throws CloneNotSupportedException {
        Document prototype = documentPrototypes.get(type);
        if (prototype == null) {
            throw new IllegalArgumentException("Unknown document type: " + type);
        }
        return prototype.clone();
    }
    
    public void addPrototype(String key, Document prototype) {
        documentPrototypes.put(key, prototype);
    }
}