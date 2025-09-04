package structural_design_patterns.proxy_pattern.example;

public class ProxyPatternExample {
    public static void main(String[] args) {
        System.out.println("Proxy Pattern Example - Image Loading System");
        System.out.println("==========================================");
        
        System.out.println("\n--- Demonstration 1: Lazy Loading ---");
        demonstrateLazyLoading();
        
        System.out.println("\n\n--- Demonstration 2: Caching Benefits ---");
        demonstrateCaching();
        
        System.out.println("\n\n--- Demonstration 3: Proxy Additional Features ---");
        demonstrateProxyFeatures();
    }
    
    private static void demonstrateLazyLoading() {
        System.out.println("Creating image proxies (no actual loading yet):");
        
        // Create proxies - these are lightweight and fast
        Image photo1 = new ImageProxy("vacation_photo.jpg");
        Image photo2 = new ImageProxy("profile_picture.png");
        Image photo3 = new ImageProxy("large_document.pdf");
        
        System.out.println("\nGetting basic info (no loading required):");
        System.out.println("Photo1 info: " + photo1.getInfo());
        System.out.println("Photo2 info: " + photo2.getInfo());
        
        System.out.println("\nNow displaying photo1 (triggers loading):");
        photo1.display();
        
        System.out.println("\nPhoto3 remains unloaded until needed:");
        System.out.println("Photo3 info: " + photo3.getInfo());
        // photo3 is never displayed, so it's never loaded - saving resources!
    }
    
    private static void demonstrateCaching() {
        System.out.println("Demonstrating caching behavior:");
        
        Image cachedPhoto = new ImageProxy("cached_image.jpg");
        
        System.out.println("First display (loads from disk):");
        cachedPhoto.display();
        
        System.out.println("\nSecond display (uses cache):");
        cachedPhoto.display();
        
        System.out.println("\nInfo requests (cached):");
        System.out.println(cachedPhoto.getInfo());
        System.out.println(cachedPhoto.getInfo());
    }
    
    private static void demonstrateProxyFeatures() {
        System.out.println("Demonstrating additional proxy features:");
        
        ImageProxy smartProxy = new ImageProxy("smart_image.jpg");
        
        System.out.println("Checking if image is loaded: " + smartProxy.isImageLoaded());
        
        System.out.println("\nPreloading image in background:");
        smartProxy.preload();
        
        System.out.println("Is image loaded now? " + smartProxy.isImageLoaded());
        
        System.out.println("\nDisplaying preloaded image (should be fast):");
        smartProxy.display();
        
        // Demonstrate different types of proxies
        System.out.println("\n--- Different Proxy Types ---");
        System.out.println("Virtual Proxy: Controls expensive object creation (like our ImageProxy)");
        System.out.println("Protection Proxy: Controls access based on permissions");
        System.out.println("Remote Proxy: Represents objects in different address spaces");
        System.out.println("Smart Proxy: Adds additional functionality (reference counting, etc.)");
    }
}