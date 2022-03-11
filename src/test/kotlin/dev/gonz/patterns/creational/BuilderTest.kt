package dev.gonz.patterns.creational

import org.junit.Test
import kotlin.test.assertEquals

class BuilderTest {

    @Test
    fun `given a normal pokemon builder, when director creates a pokemon, then pokemon power must be the same`() {
        val builder: PokemonBuilder = NormalPokemonBuilder()
        val director = PokemonDirector()
        val pokemonPower = 50.0

        val pokemon = director.constructPokemon(builder)

        assertEquals(expected = pokemonPower, actual = pokemon.pokemonPower)
    }

    @Test
    fun `given a super powered pokemon builder, when director creates a pokemon, then pokemon power must be 10 times higher`() {
        val builder: PokemonBuilder = SuperPoweredPokemonBuilder()
        val director = PokemonDirector()
        val pokemonPower = 50.0

        val pokemon = director.constructPokemon(builder)

        assertEquals(expected = pokemonPower * 10, actual = pokemon.pokemonPower)
    }
}
