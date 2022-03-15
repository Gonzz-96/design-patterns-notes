package dev.gonz.patterns.creational

import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class FactoryMethodTest {

    @Test
    fun `given a random pokemon trainer, when favorite pokemon is called, then check that it is charizard`() {
        val trainer: PokemonTrainer = RandomFolk.get()

        val favoritePokemon = trainer.favoritePokemon
        val gymResult = buffTrainersPokemon(trainer)

        assertIs<Charizard>(favoritePokemon)
        assertEquals(expected = "Charizard is getting buffed!", actual = gymResult)
    }

    @Test
    fun `given me as a pokemon trainer, when favorite pokemon is called, then check that it is dragonite`() {
        val trainer: PokemonTrainer = Gonz.get()

        val favoritePokemon = trainer.favoritePokemon
        val gymResult = buffTrainersPokemon(trainer)

        assertIs<Dragonite>(favoritePokemon)
        assertEquals(expected = "Dragonite is getting buffed!", actual = gymResult)
    }
}
