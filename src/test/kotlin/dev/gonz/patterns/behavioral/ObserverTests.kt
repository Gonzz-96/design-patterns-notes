package dev.gonz.patterns.behavioral

import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class ObserverTests {

    @Test
    fun `given three observers and two subjects, when observers are created, then assert their registration in subjects`() {
        val intSubject = IntSubject()
        val stringSubject = StringSubject()

        val observer1 = AnyObserver(intSubject, stringSubject)
        val observer2 = AnyObserver(intSubject, stringSubject)
        val observer3 = AnyObserver(intSubject, stringSubject)

        assertEquals(expected = 3, actual = intSubject.registeredObservers.size)
        assertEquals(expected = 3, actual = stringSubject.registeredObservers.size)
        assertEquals(expected = setOf(observer1, observer2, observer3), actual = intSubject.registeredObservers)
        assertEquals(expected = setOf(observer1, observer2, observer3), actual = stringSubject.registeredObservers)
    }

    @Test
    fun `given two observers and two subjects, when one subject notify its destruction, then assert reference removed from observers`() {
        val intSubject = IntSubject()
        val stringSubject = StringSubject()
        val observer1 = AnyObserver(intSubject, stringSubject)
        val observer2 = AnyObserver(intSubject, stringSubject)

        intSubject.destroy()

        assertNull(actual = observer1.intSubject)
        assertNull(actual = observer2.intSubject)
        assertNotNull(actual = observer1.stringSubject)
        assertNotNull(actual = observer2.stringSubject)
        assertEquals(expected = 0, actual = intSubject.registeredObservers.size)
        assertEquals(expected = 2, actual = stringSubject.registeredObservers.size)
    }

    @Test
    fun `given an observer and two subjects, when subjects are updated, then assert correct state updates`() {
        val intSubject = IntSubject()
        val stringSubject = StringSubject()
        val observer = AnyObserver(intSubject, stringSubject)

        (0 until 10).forEach {
            intSubject.incrementCounter()
        }
        "abcde".forEach {
            stringSubject.appendString(it.toString())
        }

        assertContentEquals(expected = (1..10).toList(), actual = observer.intValues)
        assertContentEquals(
            expected = listOf("a", "ab", "abc", "abcd", "abcde"),
            actual = observer.stringValues,
        )
    }
}