package structural_design_patterns.adapter_pattern.example;

public class AdapterPatternExample {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        
        System.out.println("Adapter Pattern Example - Media Player");
        System.out.println("======================================");
        
        System.out.println("\n--- Testing different audio formats ---");
        audioPlayer.play("mp3", "beyond_the_horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far_far_away.vlc");
        audioPlayer.play("avi", "mind_me.avi");
    }
}