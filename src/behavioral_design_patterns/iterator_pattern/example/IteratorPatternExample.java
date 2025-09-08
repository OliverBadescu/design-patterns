package behavioral_design_patterns.iterator_pattern.example;

public class IteratorPatternExample {
    public static void main(String[] args) {
        BookCollection library = new BookCollection();
        
        library.addBook(new Book("1984", "George Orwell", "Dystopian Fiction", 1949));
        library.addBook(new Book("Animal Farm", "George Orwell", "Political Satire", 1945));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Southern Gothic", 1960));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic Literature", 1925));
        library.addBook(new Book("Dune", "Frank Herbert", "Science Fiction", 1965));
        library.addBook(new Book("Foundation", "Isaac Asimov", "Science Fiction", 1951));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954));
        library.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian Fiction", 1932));
        library.addBook(new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian Fiction", 1953));
        
        System.out.println("=== Library Management System Demo ===");
        System.out.println("Total books in library: " + library.getSize());
        
        System.out.println("\n--- All Books (General Iterator) ---");
        Iterator<Book> allBooksIterator = library.createIterator();
        while (allBooksIterator.hasNext()) {
            System.out.println("📚 " + allBooksIterator.next());
        }
        
        System.out.println("\n--- Science Fiction Books Only (Genre Iterator) ---");
        Iterator<Book> sciFiIterator = library.createGenreIterator("Science Fiction");
        while (sciFiIterator.hasNext()) {
            System.out.println("🚀 " + sciFiIterator.next());
        }
        
        System.out.println("\n--- Books by George Orwell (Author Iterator) ---");
        Iterator<Book> orwellIterator = library.createAuthorIterator("George Orwell");
        while (orwellIterator.hasNext()) {
            System.out.println("✍️ " + orwellIterator.next());
        }
        
        System.out.println("\n--- Dystopian Fiction Books (Genre Iterator) ---");
        Iterator<Book> dystopianIterator = library.createGenreIterator("Dystopian Fiction");
        while (dystopianIterator.hasNext()) {
            System.out.println("🌆 " + dystopianIterator.next());
        }
        
        System.out.println("\n--- Fantasy Books (Genre Iterator) ---");
        Iterator<Book> fantasyIterator = library.createGenreIterator("Fantasy");
        while (fantasyIterator.hasNext()) {
            System.out.println("🧙 " + fantasyIterator.next());
        }
        
        System.out.println("\n--- Books by J.R.R. Tolkien (Author Iterator) ---");
        Iterator<Book> tolkienIterator = library.createAuthorIterator("J.R.R. Tolkien");
        while (tolkienIterator.hasNext()) {
            System.out.println("🧝 " + tolkienIterator.next());
        }
        
        System.out.println("\n--- Demonstrating Multiple Iterator Independence ---");
        Iterator<Book> iterator1 = library.createGenreIterator("Science Fiction");
        Iterator<Book> iterator2 = library.createAuthorIterator("George Orwell");
        
        System.out.println("First Science Fiction book: " + 
            (iterator1.hasNext() ? iterator1.next() : "None"));
        System.out.println("First Orwell book: " + 
            (iterator2.hasNext() ? iterator2.next() : "None"));
        System.out.println("Second Science Fiction book: " + 
            (iterator1.hasNext() ? iterator1.next() : "None"));
        System.out.println("Second Orwell book: " + 
            (iterator2.hasNext() ? iterator2.next() : "None"));
        
        System.out.println("\n=== Demo Complete ===");
    }
}