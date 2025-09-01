package structural_design_patterns.adapter_pattern.example;

public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}