package behavioral_design_patterns.iterator_pattern.example;

public interface Iterator<T> {
    boolean hasNext();
    T next();
}