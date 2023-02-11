package dev.gonz.patterns.behavioral.iterable.internal;

import dev.gonz.patterns.behavioral.iterable.AbstractList;
import dev.gonz.patterns.behavioral.iterable.Person;

public class PersonForwardIterator extends Iterator<Person> {

    private int currentIndex = 0;

    public PersonForwardIterator(AbstractList<Person> list) {
        super(list);
    }

    @Override
    public void forEach(Operation<Person> operation) {
        for (currentIndex = 0; currentIndex < list.getCount(); currentIndex++) {
            operation.execute(list.get(currentIndex));
        }
    }
}
