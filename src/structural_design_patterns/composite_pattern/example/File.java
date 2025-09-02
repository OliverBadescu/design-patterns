package structural_design_patterns.composite_pattern.example;

public class File extends FileSystemComponent {
    private long size;
    
    public File(String name, long size) {
        super(name);
        this.size = size;
    }
    
    @Override
    public void display(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        sb.append("📄 ").append(name).append(" (").append(size).append(" bytes)");
        System.out.println(sb.toString());
    }
    
    @Override
    public long getSize() {
        return size;
    }
}