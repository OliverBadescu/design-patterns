package creational_design_patterns.prototype_pattern.example;

public class TextDocument extends Document {
    private String encoding;
    
    public TextDocument(String title, String content, String encoding) {
        super(title, content, "Text");
        this.encoding = encoding;
    }
    
    @Override
    public Document clone() throws CloneNotSupportedException {
        return new TextDocument(this.title, this.content, this.encoding);
    }
    
    public String getEncoding() {
        return encoding;
    }
    
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
    @Override
    public String getInfo() {
        return String.format("%s Document: '%s' (%d chars, %s encoding)", 
                           format, title, content.length(), encoding);
    }
}