package dev.gonz.patterns.behavioral.iterable.external;

public class PersonBackwardList extends AbstractList<Person> {

    public PersonBackwardList(Person... persons) {
        super(persons);
    }

    @Override
    public Iterator<Person> createIterator() {
        return new PersonBackwardIterator(this);
    }
}
