package structural_design_patterns.flyweight_pattern.example;

import java.awt.*;

public class FlyweightPatternExample {
    public static void main(String[] args) {
        System.out.println("Flyweight Pattern Example - Forest Simulation");
        System.out.println("=============================================");
        
        Forest forest = new Forest();
        
        // Demonstrate memory efficiency by creating many trees
        System.out.println("\n--- Creating a forest with 1000 trees ---");
        forest.generateRandomForest(1000);
        
        // Show flyweight efficiency
        TreeTypeFactory.printCreatedTreeTypes();
        
        System.out.println("\nMemory efficiency demonstration:");
        System.out.println("===============================");
        System.out.println("Total trees in forest: " + forest.getTreeCount());
        System.out.println("Unique TreeType objects: " + TreeTypeFactory.getCreatedTreeTypesCount());
        System.out.println("Memory saved: " + (forest.getTreeCount() - TreeTypeFactory.getCreatedTreeTypesCount()) + " object instances");
        
        // Render a small portion of the forest for demonstration
        System.out.println("\n--- Manual tree planting demonstration ---");
        Forest smallForest = new Forest();
        
        // Plant some trees manually
        smallForest.plantTree(10, 20, "Oak", Color.GREEN, "oak.png");
        smallForest.plantTree(30, 40, "Pine", Color.GREEN, "pine.png");
        smallForest.plantTree(50, 60, "Oak", Color.GREEN, "oak.png"); // Reuses Oak flyweight
        smallForest.plantTree(70, 80, "Birch", Color.YELLOW, "birch.png");
        smallForest.plantTree(90, 100, "Pine", Color.GREEN, "pine.png"); // Reuses Pine flyweight
        
        smallForest.render();
        
        // Show what happens without flyweight pattern
        demonstrateMemoryImpact();
    }
    
    private static void demonstrateMemoryImpact() {
        System.out.println("\n--- Memory Impact Comparison ---");
        System.out.println("===============================");
        
        int totalTrees = 1000;
        int uniqueTreeTypes = TreeTypeFactory.getCreatedTreeTypesCount();
        
        System.out.println("Without Flyweight Pattern:");
        System.out.println("- Each tree would have its own TreeType object");
        System.out.println("- Memory usage: " + totalTrees + " TreeType objects");
        
        System.out.println("\nWith Flyweight Pattern:");
        System.out.println("- TreeType objects are shared among trees");
        System.out.println("- Memory usage: " + uniqueTreeTypes + " TreeType objects");
        
        double memoryReduction = ((double)(totalTrees - uniqueTreeTypes) / totalTrees) * 100;
        System.out.println("- Memory reduction: " + String.format("%.1f", memoryReduction) + "%");
    }
}