package structural_design_patterns.flyweight_pattern.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forest {
    private List<Tree> trees = new ArrayList<>();
    
    public void plantTree(int x, int y, String name, Color color, String sprite) {
        TreeType type = TreeTypeFactory.getTreeType(name, color, sprite);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }
    
    public void render() {
        System.out.println("\nRendering forest with " + trees.size() + " trees:");
        System.out.println("================================================");
        for (Tree tree : trees) {
            tree.render();
        }
    }
    
    public void generateRandomForest(int numberOfTrees) {
        String[] treeNames = {"Oak", "Pine", "Birch"};
        Color[] colors = {Color.GREEN, Color.ORANGE, Color.YELLOW};
        String[] sprites = {"oak.png", "pine.png", "birch.png"};
        
        Random random = new Random();
        
        System.out.println("Generating forest with " + numberOfTrees + " trees:");
        System.out.println("===================================================");
        
        for (int i = 0; i < numberOfTrees; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            String name = treeNames[random.nextInt(treeNames.length)];
            Color color = colors[random.nextInt(colors.length)];
            String sprite = sprites[random.nextInt(sprites.length)];
            
            plantTree(x, y, name, color, sprite);
        }
    }
    
    public int getTreeCount() {
        return trees.size();
    }
}