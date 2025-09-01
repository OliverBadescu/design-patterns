package creational_design_patterns.singleton_pattern.example;

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private String connectionString;
    private boolean isConnected;
    
    private DatabaseConnection() {
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        this.isConnected = false;
        System.out.println("DatabaseConnection instance created");
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    public void connect() {
        if (!isConnected) {
            System.out.println("Connecting to database: " + connectionString);
            isConnected = true;
        } else {
            System.out.println("Already connected to database");
        }
    }
    
    public void disconnect() {
        if (isConnected) {
            System.out.println("Disconnecting from database");
            isConnected = false;
        } else {
            System.out.println("Already disconnected from database");
        }
    }
    
    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("Executing query: " + query);
        } else {
            System.out.println("Cannot execute query. Not connected to database.");
        }
    }
    
    public String getConnectionString() {
        return connectionString;
    }
    
    public boolean isConnected() {
        return isConnected;
    }
}