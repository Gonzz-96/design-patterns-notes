package dev.gonz.patterns.behavioral.iterable.external;

import dev.gonz.patterns.behavioral.iterable.AbstractList;
import dev.gonz.patterns.behavioral.iterable.Person;

public class PersonForwardList extends AbstractList<Person> {

    public PersonForwardList(Person... persons) {
        super(persons);
    }

    @Override
    public Iterator<Person> createIterator() {
        return new PersonForwardIterator(this);
    }
}
