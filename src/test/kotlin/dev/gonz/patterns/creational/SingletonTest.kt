package dev.gonz.patterns.creational

import org.junit.Test
import kotlin.test.assertSame

class SingletonTest {

    @Test
    fun `given a Singleton class, when 'get' is called, verify we are dealing with the same instance`() {
        val legendaryPokemon = LegendaryPokemon.get()

        assertSame(expected = LegendaryPokemon.get(), actual = legendaryPokemon)
    }
}