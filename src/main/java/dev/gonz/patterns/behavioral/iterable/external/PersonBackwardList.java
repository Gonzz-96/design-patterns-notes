package dev.gonz.patterns.behavioral.iterable.external;

import dev.gonz.patterns.behavioral.iterable.AbstractList;
import dev.gonz.patterns.behavioral.iterable.Person;

public class PersonBackwardList extends AbstractList<Person> {

    public PersonBackwardList(Person... persons) {
        super(persons);
    }

    @Override
    public Iterator<Person> createIterator() {
        return new PersonBackwardIterator(this);
    }
}
