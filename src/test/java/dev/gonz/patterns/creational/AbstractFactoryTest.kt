package dev.gonz.patterns.creational

import org.junit.Test
import kotlin.test.assertEquals

class AbstractFactoryTest {

    @Test
    fun `given the Kanto region and an abstract factory, when factory methods are call, check correct instance of pokemon`() {
        val region = Region.KANTO
        val pokemonFactory = PokemonFactory.getFactoryOf(region)

        val firePokemon = pokemonFactory.newFirePokemon()
        val waterPokemon = pokemonFactory.newWaterPokemon()
        val grassPokemon = pokemonFactory.newGrassPokemon()

        assertEquals(expected = Charmander, actual = firePokemon)
        assertEquals(expected = Squirtle, actual = waterPokemon)
        assertEquals(expected = Bulbasaur, actual = grassPokemon)
    }

    @Test
    fun `given the Johto region and an abstract factory, when factory methods are call, check correct instance of pokemon`() {
        val region = Region.JOHTO
        val pokemonFactory = PokemonFactory.getFactoryOf(region)

        val firePokemon = pokemonFactory.newFirePokemon()
        val waterPokemon = pokemonFactory.newWaterPokemon()
        val grassPokemon = pokemonFactory.newGrassPokemon()

        assertEquals(expected = Cyndaquil, actual = firePokemon)
        assertEquals(expected = Totodile, actual = waterPokemon)
        assertEquals(expected = Chikorita, actual = grassPokemon)
    }

    @Test
    fun `given the Hoenn region and an abstract factory, when factory methods are call, check correct instance of pokemon`() {
        val region = Region.HOENN
        val pokemonFactory = PokemonFactory.getFactoryOf(region)

        val firePokemon = pokemonFactory.newFirePokemon()
        val waterPokemon = pokemonFactory.newWaterPokemon()
        val grassPokemon = pokemonFactory.newGrassPokemon()

        assertEquals(expected = Torchic, actual = firePokemon)
        assertEquals(expected = Mudkip, actual = waterPokemon)
        assertEquals(expected = Tricko, actual = grassPokemon)
    }
}
