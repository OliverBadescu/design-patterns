package behavioral_design_patterns.iterator_pattern.example;

public class BookIterator implements Iterator<Book> {
    private BookCollection collection;
    private int currentIndex;
    
    public BookIterator(BookCollection collection) {
        this.collection = collection;
        this.currentIndex = 0;
    }
    
    @Override
    public boolean hasNext() {
        return currentIndex < collection.getSize();
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