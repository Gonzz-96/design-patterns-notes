package dev.gonz.patterns.structural

import org.junit.Test
import kotlin.test.assertEquals

class CompositeTest {

    @Test
    fun `given a set of component instances, when composite object is set, then check the price is correct`() {
        val randomStuffBox = Box().apply {
            add(Product(5, "stuffed-animal"))
            add(Product(1000, "iphone-lol"))
        }
        val keyboardMouseBox = Box().apply {
            add(Product(100, "keyboard"))
            add(Product(30, "mouse"))
            add(randomStuffBox)
        }
        val biggerBox = Box().apply {
            add(LittleBox(Product(50, "head-set")))
            add(LittleBox(Product(100, "hdmi-adapter")))
            add(LittleBox(Product(15, "mouse-pad")))
            add(keyboardMouseBox)
        }

        assertEquals(
            expected = (5 + 1000 + 100 + 30 + 50 + 100 + 15), // prices of everything
            actual = biggerBox.price(),
        )
    }
}
