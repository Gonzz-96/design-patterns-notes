package dev.gonz.patterns.behavioral.iterable.internal;

import dev.gonz.patterns.behavioral.iterable.AbstractList;

public abstract class Iterator<T> {

    protected final AbstractList<T> list;

    public Iterator(AbstractList<T> list) {
        this.list = list;
    }

    public abstract void forEach(Operation<T> operation);

    public interface Operation<T> {
        void execute(T item);
    }
}
