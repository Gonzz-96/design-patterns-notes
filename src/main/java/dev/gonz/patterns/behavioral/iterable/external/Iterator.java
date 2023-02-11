package dev.gonz.patterns.behavioral.iterable.external;

public interface Iterator<T> {
    void first();
    void next();
    boolean isDone();
    T currentItem();
}
