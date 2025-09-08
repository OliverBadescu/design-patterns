package behavioral_design_patterns.iterator_pattern.example;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}