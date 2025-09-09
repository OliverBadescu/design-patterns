package behavioral_design_patterns.state_pattern.example;

public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State soldState;
    private State outOfStockState;
    
    private State currentState;
    private int productCount;
    private String selectedProduct = "";
    
    public VendingMachine(int productCount) {
        this.noCoinState = new NoCoinState();
        this.hasCoinState = new HasCoinState();
        this.soldState = new SoldState();
        this.outOfStockState = new OutOfStockState();
        
        this.productCount = productCount;
        this.currentState = (productCount > 0) ? noCoinState : outOfStockState;
    }
    
    public void insertCoin() {
        System.out.println("Inserting coin...");
        currentState.insertCoin(this);
    }
    
    public void ejectCoin() {
        System.out.println("Ejecting coin...");
        currentState.ejectCoin(this);
    }
    
    public void selectProduct(String product) {
        System.out.println("Selecting product: " + product);
        selectedProduct = product;
        currentState.selectProduct(this);
    }
    
    public void dispenseProduct() {
        currentState.dispenseProduct(this);
        if (productCount > 0 && currentState != outOfStockState) {
            productCount--;
            System.out.println("Product dispensed: " + selectedProduct);
            System.out.println("Products remaining: " + productCount);
            selectedProduct = "";
            
            if (productCount == 0) {
                setState(outOfStockState);
                System.out.println("Machine is now out of stock!");
            } else {
                setState(noCoinState);
            }
        }
    }
    
    public void setState(State state) {
        this.currentState = state;
    }
    
    public String getSelectedProduct() {
        return selectedProduct;
    }
    
    public int getProductCount() {
        return productCount;
    }
    
    public State getCurrentState() {
        return currentState;
    }
    
    public String getStateName() {
        if (currentState == noCoinState) return "No Coin";
        if (currentState == hasCoinState) return "Has Coin";
        if (currentState == soldState) return "Sold";
        if (currentState == outOfStockState) return "Out of Stock";
        return "Unknown";
    }
    
    // Getters for states
    public State getNoCoinState() { return noCoinState; }
    public State getHasCoinState() { return hasCoinState; }
    public State getSoldState() { return soldState; }
    public State getOutOfStockState() { return outOfStockState; }
}