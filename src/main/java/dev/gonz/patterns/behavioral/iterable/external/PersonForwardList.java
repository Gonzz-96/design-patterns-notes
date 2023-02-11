package dev.gonz.patterns.behavioral.iterable.external;

public class PersonForwardList extends AbstractList<Person> {

    public PersonForwardList(Person... persons) {
        super(persons);
    }

    @Override
    public Iterator<Person> createIterator() {
        return new PersonForwardIterator(this);
    }
}
