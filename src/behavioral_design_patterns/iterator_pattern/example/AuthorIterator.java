package behavioral_design_patterns.iterator_pattern.example;

public class AuthorIterator implements Iterator<Book> {
    private BookCollection collection;
    private String targetAuthor;
    private int currentIndex;
    
    public AuthorIterator(BookCollection collection, String author) {
        this.collection = collection;
        this.targetAuthor = author;
        this.currentIndex = 0;
    }
    
    @Override
    public boolean hasNext() {
        while (currentIndex < collection.getSize()) {
            Book book = collection.getBookAt(currentIndex);
            if (book != null && book.getAuthor().equalsIgnoreCase(targetAuthor)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }
    
    @Override
    public Book next() {
        if (hasNext()) {
            Book book = collection.getBookAt(currentIndex);
            currentIndex++;
            return book;
        }
        return null;
    }
}