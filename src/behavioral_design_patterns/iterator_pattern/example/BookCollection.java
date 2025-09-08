package behavioral_design_patterns.iterator_pattern.example;

import java.util.ArrayList;
import java.util.List;

public class BookCollection implements Aggregate<Book> {
    private List<Book> books;
    
    public BookCollection() {
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void removeBook(Book book) {
        books.remove(book);
    }
    
    public int getSize() {
        return books.size();
    }
    
    public Book getBookAt(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }
    
    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator(this);
    }
    
    public Iterator<Book> createGenreIterator(String genre) {
        return new GenreIterator(this, genre);
    }
    
    public Iterator<Book> createAuthorIterator(String author) {
        return new AuthorIterator(this, author);
    }
}