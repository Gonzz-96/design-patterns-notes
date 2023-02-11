package dev.gonz.patterns.behavioral.iterable.external;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class ExternalIterableTest {

    @Test
    public void givenAListOfPersons_whenForwardIterableIsUsed_thenAssertListWithElementsInCorrectOrder() {
        AbstractList<Person> list = new PersonForwardList(new Person("Gonz", 26), new Person("Abril", 24));
        Iterator<Person> iterator = list.createIterator();
        ArrayList<String> resultsList = new ArrayList<>();

        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            resultsList.add(iterator.currentItem().print());
        }

        assertArrayEquals(
                new String[]{"Person(name = Gonz, age = 26)", "Person(name = Abril, age = 24)"},
                resultsList.toArray());
    }

    @Test
    public void givenAListOfPersons_whenBackwardIterableIsUsed_thenAssertListWithElementsInCorrectOrder() {
        AbstractList<Person> list = new PersonBackwardList(new Person("Gonz", 26), new Person("Abril", 24));
        Iterator<Person> iterator = list.createIterator();
        ArrayList<String> resultsList = new ArrayList<>();

        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            resultsList.add(iterator.currentItem().print());
        }

        assertArrayEquals(
                new String[]{"Person(name = Abril, age = 24)", "Person(name = Gonz, age = 26)"},
                resultsList.toArray());
    }
}