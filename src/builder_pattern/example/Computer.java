package builder_pattern.example;

public class Computer {
    private String processor;
    private String memory;
    private String storage;
    private String graphicsCard;
    private String powerSupply;
    private boolean hasWiFi;
    private boolean hasBluetooth;
    
    private Computer(ComputerBuilder builder) {
        this.processor = builder.processor;
        this.memory = builder.memory;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
        this.hasWiFi = builder.hasWiFi;
        this.hasBluetooth = builder.hasBluetooth;
    }
    
    public String getProcessor() {
        return processor;
    }
    
    public String getMemory() {
        return memory;
    }
    
    public String getStorage() {
        return storage;
    }
    
    public String getGraphicsCard() {
        return graphicsCard;
    }
    
    public String getPowerSupply() {
        return powerSupply;
    }
    
    public boolean hasWiFi() {
        return hasWiFi;
    }
    
    public boolean hasBluetooth() {
        return hasBluetooth;
    }
    
    @Override
    public String toString() {
        StringBuilder spec = new StringBuilder();
        spec.append("Computer Specifications:\n");
        spec.append("- Processor: ").append(processor).append("\n");
        spec.append("- Memory: ").append(memory).append("\n");
        spec.append("- Storage: ").append(storage).append("\n");
        spec.append("- Graphics: ").append(graphicsCard).append("\n");
        spec.append("- Power Supply: ").append(powerSupply).append("\n");
        spec.append("- WiFi: ").append(hasWiFi ? "Yes" : "No").append("\n");
        spec.append("- Bluetooth: ").append(hasBluetooth ? "Yes" : "No");
        return spec.toString();
    }
    
    public static class ComputerBuilder {
        private String processor;
        private String memory;
        private String storage;
        private String graphicsCard;
        private String powerSupply;
        private boolean hasWiFi = false;
        private boolean hasBluetooth = false;
        
        public ComputerBuilder(String processor, String memory) {
            this.processor = processor;
            this.memory = memory;
        }
        
        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        
        public ComputerBuilder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }
        
        public ComputerBuilder enableWiFi() {
            this.hasWiFi = true;
            return this;
        }
        
        public ComputerBuilder enableBluetooth() {
            this.hasBluetooth = true;
            return this;
        }
        
        public Computer build() {
            if (storage == null) storage = "256GB SSD";
            if (graphicsCard == null) graphicsCard = "Integrated Graphics";
            if (powerSupply == null) powerSupply = "500W";
            
            return new Computer(this);
        }
    }
}