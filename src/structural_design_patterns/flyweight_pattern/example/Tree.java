package structural_design_patterns.flyweight_pattern.example;

public class Tree {
    private int x;
    private int y;
    private TreeType treeType;
    
    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }
    
    public void render() {
        treeType.operation(x + "," + y);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public TreeType getTreeType() {
        return treeType;
    }
}