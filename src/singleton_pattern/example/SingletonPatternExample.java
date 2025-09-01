package singleton_pattern.example;

public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("Singleton Pattern Example - Database Connection");
        System.out.println("===============================================");
        
        System.out.println("\n1. Getting first instance of DatabaseConnection:");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        
        System.out.println("\n2. Getting second instance of DatabaseConnection:");
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        System.out.println("\n3. Checking if both references point to the same instance:");
        System.out.println("db1 == db2: " + (db1 == db2));
        System.out.println("db1.hashCode(): " + db1.hashCode());
        System.out.println("db2.hashCode(): " + db2.hashCode());
        
        System.out.println("\n4. Using the singleton instance:");
        db1.connect();
        db1.executeQuery("SELECT * FROM users");
        
        System.out.println("\n5. Using the second reference (same instance):");
        db2.executeQuery("SELECT * FROM products");
        db2.disconnect();
        
        System.out.println("\n6. Demonstrating thread safety with multiple threads:");
        Thread thread1 = new Thread(() -> {
            DatabaseConnection dbThread1 = DatabaseConnection.getInstance();
            System.out.println("Thread 1 - Instance hash: " + dbThread1.hashCode());
        });
        
        Thread thread2 = new Thread(() -> {
            DatabaseConnection dbThread2 = DatabaseConnection.getInstance();
            System.out.println("Thread 2 - Instance hash: " + dbThread2.hashCode());
        });
        
        Thread thread3 = new Thread(() -> {
            DatabaseConnection dbThread3 = DatabaseConnection.getInstance();
            System.out.println("Thread 3 - Instance hash: " + dbThread3.hashCode());
        });
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("\nAll threads completed. All instances should have the same hash code.");
    }
}