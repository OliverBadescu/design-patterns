package structural_design_patterns.flyweight_pattern.example;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();
    
    public static TreeType getTreeType(String name, Color color, String sprite) {
        String key = name + "_" + color.toString();
        TreeType treeType = treeTypes.get(key);
        
        if (treeType == null) {
            System.out.println("Creating new TreeType: " + name + " with color " + colorToString(color));
            treeType = new TreeType(name, color, sprite);
            treeTypes.put(key, treeType);
        } else {
            System.out.println("Reusing existing TreeType: " + name + " with color " + colorToString(color));
        }
        
        return treeType;
    }
    
    public static int getCreatedTreeTypesCount() {
        return treeTypes.size();
    }
    
    public static void printCreatedTreeTypes() {
        System.out.println("\nCreated TreeType objects:");
        System.out.println("========================");
        for (String key : treeTypes.keySet()) {
            TreeType treeType = treeTypes.get(key);
            System.out.println("- " + treeType.getName() + " (" + colorToString(treeType.getColor()) + ")");
        }
        System.out.println("Total unique TreeTypes: " + treeTypes.size());
    }
    
    private static String colorToString(Color color) {
        if (color.equals(Color.GREEN)) return "GREEN";
        if (color.equals(Color.ORANGE)) return "ORANGE";
        if (color.equals(Color.YELLOW)) return "YELLOW";
        return "UNKNOWN";
    }
}