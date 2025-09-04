package structural_design_patterns.proxy_pattern.example;

/**
 * Subject interface - defines common operations for both RealImage and ProxyImage
 */
public interface Image {
    /**
     * Display the image
     */
    void display();
    
    /**
     * Get image information
     */
    String getInfo();
}