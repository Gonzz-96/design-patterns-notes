package dev.gonz.patterns.creational

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class AbstractFactoryTest {

    @Test
    fun `given the Kanto region and an abstract factory, when factory methods are call, check correct instance of pokemon`() {
        val region = Region.KANTO
        val pokemonFactory = PokemonFactory.getFactoryOf(region)

        val firePokemon = pokemonFactory.newFirePokemon()
        val waterPokemon = pokemonFactory.newWaterPokemon()
        val grassPokemon = pokemonFactory.newGrassPokemon()

        assertEquals(expected = Charmander, actual = firePokemon); assertIs<KantoPokemon>(firePokemon)
        assertEquals(expected = Squirtle, actual = waterPokemon); assertIs<KantoPokemon>(waterPokemon)
        assertEquals(expected = Bulbasaur, actual = grassPokemon); assertIs<KantoPokemon>(grassPokemon)
    }

    @Test
    fun `given the Johto region and an abstract factory, when factory methods are call, check correct instance of pokemon`() {
        val region = Region.JOHTO
        val pokemonFactory = PokemonFactory.getFactoryOf(region)

        val firePokemon = pokemonFactory.newFirePokemon()
        val waterPokemon = pokemonFactory.newWaterPokemon()
        val grassPokemon = pokemonFactory.newGrassPokemon()

        assertEquals(expected = Cyndaquil, actual = firePokemon); assertIs<JohtoPokemon>(firePokemon)
        assertEquals(expected = Totodile, actual = waterPokemon); assertIs<JohtoPokemon>(waterPokemon)
        assertEquals(expected = Chikorita, actual = grassPokemon); assertIs<JohtoPokemon>(grassPokemon)
    }

    @Test
    fun `given the Hoenn region and an abstract factory, when factory methods are call, check correct instance of pokemon`() {
        val region = Region.HOENN
        val pokemonFactory = PokemonFactory.getFactoryOf(region)

        val firePokemon = pokemonFactory.newFirePokemon()
        val waterPokemon = pokemonFactory.newWaterPokemon()
        val grassPokemon = pokemonFactory.newGrassPokemon()

        assertEquals(expected = Torchic, actual = firePokemon); assertIs<HoennPokemon>(firePokemon)
        assertEquals(expected = Mudkip, actual = waterPokemon); assertIs<HoennPokemon>(waterPokemon)
        assertEquals(expected = Tricko, actual = grassPokemon); assertIs<HoennPokemon>(grassPokemon)
    }
}
