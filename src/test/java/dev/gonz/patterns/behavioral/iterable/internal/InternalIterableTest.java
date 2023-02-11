package dev.gonz.patterns.behavioral.iterable.internal;

import dev.gonz.patterns.behavioral.iterable.AbstractList;
import dev.gonz.patterns.behavioral.iterable.Person;
import dev.gonz.patterns.behavioral.iterable.external.PersonForwardList;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class InternalIterableTest {

    @Test
    public void givenAnInternalIterable_whenPasserdInAnOperation_thenExpectListWithResults() {
        AbstractList<Person> list = new PersonForwardList(new Person("Gonz", 26), new Person("Abril", 24));
        Iterator<Person> iterator = new PersonForwardIterator(list);
        ArrayList<String> resultList = new ArrayList<>();

        iterator.forEach((item) -> resultList.add(item.print()));

        assertArrayEquals(
                new String[]{"Person(name = Gonz, age = 26)", "Person(name = Abril, age = 24)"},
                resultList.toArray());
    }
}
