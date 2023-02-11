package dev.gonz.patterns.behavioral.iterable.external;

public class PersonBackwardIterator implements Iterator<Person> {

    private final AbstractList<Person> personsList;
    private int currentIndex;

    public PersonBackwardIterator(AbstractList<Person> list) {
        this.personsList = list;
        currentIndex = lastIndex();
    }

    private int lastIndex() {
        return personsList.getCount() - 1;
    }

    @Override
    public void first() {
        currentIndex = lastIndex();
    }

    @Override
    public void next() {
        currentIndex--;
    }

    @Override
    public boolean isDone() {
        return currentIndex < 0;
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
