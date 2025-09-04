package structural_design_patterns.proxy_pattern.example;

/**
 * RealSubject - the actual object that performs the real work
 * This represents an expensive operation (loading image from disk)
 */
public class RealImage implements Image {
    private String filename;
    private boolean isLoaded;
    private String imageData;
    
    public RealImage(String filename) {
        this.filename = filename;
        this.isLoaded = false;
        // Note: We don't load immediately - this allows for lazy loading via proxy
    }
    
    /**
     * Expensive operation - simulates loading image from disk
     */
    private void loadImageFromDisk() {
        if (!isLoaded) {
            System.out.println("    [RealImage] Loading image from disk: " + filename);
            // Simulate expensive disk I/O operation
            try {
                Thread.sleep(2000); // Simulate 2 second load time
                this.imageData = "Binary image data for: " + filename;
                this.isLoaded = true;
                System.out.println("    [RealImage] Image loaded successfully!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("    [RealImage] Image loading interrupted!");
            }
        }
    }
    
    @Override
    public void display() {
        loadImageFromDisk(); // Ensure image is loaded before displaying
        System.out.println("    [RealImage] Displaying image: " + filename);
        System.out.println("    [RealImage] Image content: " + imageData);
    }
    
    @Override
    public String getInfo() {
        // This operation doesn't require loading the image
        return "Real image: " + filename + " (loaded: " + isLoaded + ")";
    }
}