package behavioral_design_patterns.iterator_pattern.example;

public class GenreIterator implements Iterator<Book> {
    private BookCollection collection;
    private String targetGenre;
    private int currentIndex;
    
    public GenreIterator(BookCollection collection, String genre) {
        this.collection = collection;
        this.targetGenre = genre;
        this.currentIndex = 0;
    }
    
    @Override
    public boolean hasNext() {
        while (currentIndex < collection.getSize()) {
            Book book = collection.getBookAt(currentIndex);
            if (book != null && book.getGenre().equalsIgnoreCase(targetGenre)) {
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