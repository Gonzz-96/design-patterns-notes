package dev.gonz.patterns.behavioral.iterable.external;

import dev.gonz.patterns.behavioral.iterable.AbstractList;

public class PersonForwardIterator implements Iterator<Person> {

    private int currentIndex = 0;

    private final AbstractList<Person> personsList;

    public PersonForwardIterator(AbstractList<Person> list) {
        this.personsList = list;
    }

    @Override
    public void first() {
        currentIndex = 0;
    }

    @Override
    public void next() {
        currentIndex++;
    }

    @Override
    public boolean isDone() {
        return currentIndex >= personsList.getCount();
    }

    @Override
    public Person currentItem() {
        if (!isDone()) {
            return personsList.get(currentIndex);
        } else {
            return null;
        }
    }
}
