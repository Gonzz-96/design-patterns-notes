package dev.gonz.patterns.behavioral.iterable;

import dev.gonz.patterns.behavioral.iterable.external.Iterator;

public abstract class AbstractList<T> {

    final private T[] elements;

    public AbstractList(T... elements) {
        this.elements = elements;
    }

    public abstract Iterator<T> createIterator();

    public int getCount() {
        return elements.length;
    }

    public T get(int index) {
        return index < elements.length
                ? elements[index]
                : null;
    }
}
