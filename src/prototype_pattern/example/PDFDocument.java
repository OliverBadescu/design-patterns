package prototype_pattern.example;

public class PDFDocument extends Document {
    private boolean isEncrypted;
    private int pageCount;
    
    public PDFDocument(String title, String content, boolean isEncrypted, int pageCount) {
        super(title, content, "PDF");
        this.isEncrypted = isEncrypted;
        this.pageCount = pageCount;
    }
    
    @Override
    public Document clone() throws CloneNotSupportedException {
        return new PDFDocument(this.title, this.content, this.isEncrypted, this.pageCount);
    }
    
    public boolean isEncrypted() {
        return isEncrypted;
    }
    
    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }
    
    public int getPageCount() {
        return pageCount;
    }
    
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    @Override
    public String getInfo() {
        return String.format("%s Document: '%s' (%d chars, %d pages, %s)", 
                           format, title, content.length(), pageCount, 
                           isEncrypted ? "encrypted" : "not encrypted");
    }
}