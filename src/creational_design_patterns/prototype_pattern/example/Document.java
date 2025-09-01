package creational_design_patterns.prototype_pattern.example;

public abstract class Document implements Cloneable {
    protected String title;
    protected String content;
    protected String format;
    
    public Document(String title, String content, String format) {
        this.title = title;
        this.content = content;
        this.format = format;
    }
    
    public abstract Document clone() throws CloneNotSupportedException;
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getFormat() {
        return format;
    }
    
    public String getInfo() {
        return String.format("%s Document: '%s' (%d chars)", 
                           format, title, content.length());
    }
}