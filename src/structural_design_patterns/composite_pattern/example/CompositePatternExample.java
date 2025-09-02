package structural_design_patterns.composite_pattern.example;

public class CompositePatternExample {
    public static void main(String[] args) {
        System.out.println("=== Composite Pattern Example: File System ===\n");
        
        // Create files (leaf nodes)
        File file1 = new File("document.txt", 1024);
        File file2 = new File("image.jpg", 2048);
        File file3 = new File("config.xml", 512);
        File file4 = new File("readme.md", 256);
        File file5 = new File("main.java", 4096);
        
        // Create directories (composite nodes)
        Directory rootDir = new Directory("root");
        Directory documentsDir = new Directory("documents");
        Directory imagesDir = new Directory("images");
        Directory srcDir = new Directory("src");
        
        // Build the file system structure
        rootDir.add(file3); // config.xml in root
        rootDir.add(documentsDir);
        rootDir.add(imagesDir);
        rootDir.add(srcDir);
        
        documentsDir.add(file1); // document.txt in documents
        documentsDir.add(file4); // readme.md in documents
        
        imagesDir.add(file2); // image.jpg in images
        
        srcDir.add(file5); // main.java in src
        
        // Create a nested directory structure
        Directory subDir = new Directory("utils");
        File utilFile = new File("helper.java", 1536);
        subDir.add(utilFile);
        srcDir.add(subDir);
        
        System.out.println("File System Structure:");
        System.out.println("======================");
        rootDir.display(0);
        
        System.out.println("\n=== Individual Operations ===");
        System.out.println("Root directory total size: " + rootDir.getSize() + " bytes");
        System.out.println("Documents directory size: " + documentsDir.getSize() + " bytes");
        System.out.println("Source directory size: " + srcDir.getSize() + " bytes");
        
        // Demonstrate uniform treatment
        System.out.println("\n=== Uniform Treatment Demonstration ===");
        FileSystemComponent[] components = {file1, documentsDir, srcDir};
        
        for (FileSystemComponent component : components) {
            System.out.println(component.getName() + " - Size: " + component.getSize() + " bytes");
        }
        
        // Demonstrate adding new components
        System.out.println("\n=== Adding New Component ===");
        File newFile = new File("new_file.txt", 750);
        rootDir.add(newFile);
        
        System.out.println("Updated file system structure:");
        rootDir.display(0);
    }
}