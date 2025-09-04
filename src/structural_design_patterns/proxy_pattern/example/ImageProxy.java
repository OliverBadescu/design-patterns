package structural_design_patterns.proxy_pattern.example;

/**
 * Proxy - controls access to RealImage and adds additional functionality
 * This is a Virtual Proxy that provides lazy loading and caching
 */
public class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;
    private String cachedInfo;
    private boolean hasDisplayed;
    
    public ImageProxy(String filename) {
        this.filename = filename;
        this.hasDisplayed = false;
        System.out.println("[ImageProxy] Proxy created for: " + filename);
    }
    
    @Override
    public void display() {
        System.out.println("[ImageProxy] Display request received for: " + filename);
        
        // Check if we've already displayed this image
        if (hasDisplayed) {
            System.out.println("[ImageProxy] Using cached display - no need to reload");
        } else {
            System.out.println("[ImageProxy] First display request - creating real image");
        }
        
        // Lazy initialization - create RealImage only when needed
        if (realImage == null) {
            System.out.println("[ImageProxy] Creating RealImage instance...");
            realImage = new RealImage(filename);
        }
        
        // Delegate to the real object
        realImage.display();
        hasDisplayed = true;
        
        System.out.println("[ImageProxy] Display completed");
    }
    
    @Override
    public String getInfo() {
        // Proxy can provide basic info without loading the real image
        if (cachedInfo == null) {
            System.out.println("[ImageProxy] Caching basic info for: " + filename);
            cachedInfo = "Proxy for image: " + filename;
            
            // If real image exists, get its info too
            if (realImage != null) {
                cachedInfo += " | " + realImage.getInfo();
            }
        } else {
            System.out.println("[ImageProxy] Returning cached info");
        }
        
        return cachedInfo;
    }
    
    /**
     * Additional proxy functionality - check if image is loaded
     */
    public boolean isImageLoaded() {
        return realImage != null;
    }
    
    /**
     * Additional proxy functionality - preload image
     */
    public void preload() {
        System.out.println("[ImageProxy] Preloading image: " + filename);
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        // Force loading by calling display without showing output
        System.out.println("[ImageProxy] Initiating background load...");
        realImage.display();
        hasDisplayed = true;
    }
}