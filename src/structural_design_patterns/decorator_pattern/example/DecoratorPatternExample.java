package structural_design_patterns.decorator_pattern.example;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("Decorator Pattern Example - Coffee Shop");
        System.out.println("=====================================");
        
        // Start with simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println("\n--- Order 1: Basic Coffee ---");
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());
        
        // Add milk
        coffee = new MilkDecorator(coffee);
        System.out.println("\n--- Order 2: Coffee with Milk ---");
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());
        
        // Add sugar
        coffee = new SugarDecorator(coffee);
        System.out.println("\n--- Order 3: Coffee with Milk and Sugar ---");
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());
        
        // Create a new coffee with multiple decorators
        Coffee fancyCoffee = new SimpleCoffee();
        fancyCoffee = new MilkDecorator(fancyCoffee);
        fancyCoffee = new SugarDecorator(fancyCoffee);
        fancyCoffee = new WhippedCreamDecorator(fancyCoffee);
        
        System.out.println("\n--- Order 4: Fancy Coffee ---");
        System.out.println(fancyCoffee.getDescription() + " - $" + fancyCoffee.getCost());
        
        // Create another combination
        Coffee doubleMilkCoffee = new SimpleCoffee();
        doubleMilkCoffee = new MilkDecorator(doubleMilkCoffee);
        doubleMilkCoffee = new MilkDecorator(doubleMilkCoffee);
        doubleMilkCoffee = new WhippedCreamDecorator(doubleMilkCoffee);
        
        System.out.println("\n--- Order 5: Double Milk Coffee ---");
        System.out.println(doubleMilkCoffee.getDescription() + " - $" + doubleMilkCoffee.getCost());
    }
}